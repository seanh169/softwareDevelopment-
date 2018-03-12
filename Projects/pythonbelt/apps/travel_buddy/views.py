from __future__ import unicode_literals
from django.shortcuts import render, redirect
from django.db.models import Count
from .models import User, Travel
from django.contrib import messages

def index(request):
    
    return render(request, "travel_buddy/index.html")

def register(request):
    
    whatever_register_returned = User.objects.register(request.POST)
    if whatever_register_returned[0]:
        request.session["user_id"] = whatever_register_returned[1].id
        messages.add_message(request, messages.SUCCESS, 'You successfully registered, good job!')
        return redirect("/travels")
    else:
        for error in whatever_register_returned[1]:
            messages.add_message(request, messages.ERROR, error)
    return redirect("/")

def login(request):
    user = User.objects.login(request.POST)
    
    
    if user["is_valid"]:
    	
        request.session["user_id"] = user["user"].id
        
        messages.add_message(request, messages.SUCCESS, 'You successfully logged in, good job!')
        return redirect("/travels" , user)
    else:
        for error in user["errors"]:
            messages.add_message(request, messages.ERROR, error)
    return redirect("/")

def logout(request):
    request.session.clear()
    messages.add_message(request, messages.SUCCESS, "You have just logged out, goodbye!")
    return redirect("/")
def success(request):
	
	data = {
		"user": User.objects.get(id=request.session["user_id"]),
		'travels': Travel.objects.all(),
		"others": Travel.objects.all().exclude(tempo__id=request.session['user_id']),
	}

	return render(request, 'travel_buddy/main.html', data)
def add_plan(request):
	
	
	return render(request, 'travel_buddy/add.html')







def create(request):
	
	newplan= Travel.objects.travelvalidations(request.POST, request.session["user_id"])
	
	if newplan[0] == True:
		return redirect('/travels')
	else:
		for message in newplan[1]:
			messages.error(request, message)
        return redirect('/add')
def show(request, travel_id):
	travel= Travel.objects.get(id=travel_id)
	dictis={
        "travel": travel,
        "user":User.objects.get(id=request.session['user_id']),
        "others": User.objects.exclude(id=travel.starter.id),
    }

	return render(request, 'travel_buddy/show.html', dictis)

def join(request, travel_id):
    
    joiner= Travel.objects.join(request.session["user_id"], travel_id)
    # print 80 * ('*'), joiner
    if 'errors' in joiner:
        messages.error(request, joiner['errors'])
    return redirect('/travels', joiner)

	









