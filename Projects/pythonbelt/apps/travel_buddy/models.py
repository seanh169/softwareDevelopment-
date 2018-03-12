# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.db import models
import re
from datetime import date, datetime
from time import strptime
import bcrypt

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9+-_.]+\.[a-zA-Z]+$')

class UserManager(models.Manager):
    def register(self, post_data):

        errors = []
        
        if len(post_data["first"]) < 1:
            errors.append("First name is required")
        elif len(post_data["first"]) < 3:
            errors.append("First name must be at least 3 characters long")

        if len(post_data["last"]) < 1:
            errors.append("Last name is required")
        elif len(post_data["last"]) < 3:
            errors.append("Last name must be at least 3 characters long")

        if len(post_data["email"]) < 1:
            errors.append("Email is required")
        elif not EMAIL_REGEX.match(post_data["email"]):
            errors.append("Invalid email")
        else:
            list_of_users_matching_email = User.objects.filter(email=post_data["email"].lower())
            if len(list_of_users_matching_email) > 0:
                response["errors"].append("Email already exists")

        if len(post_data["password"]) < 1:
            errors.append("Password is required")
        elif len(post_data["password"]) < 8:
            errors.append("Password must be 8 characters or more")

        if len(post_data["confirm"]) < 1:
            errors.append("Confirm password is required")
        elif post_data["password"] != post_data["confirm"]:
            errors.append("Confirm password must match Password")

        if len(post_data["date_of_birth"]) < 1:
            errors.append("Date of Birth is required")
        else:
            dob = datetime.strptime(post_data["date_of_birth"], "%Y-%m-%d")
            if dob > datetime.now():
                errors.append("Date of Birth must be in the past")

        if len(errors) > 0:
            return (False, errors)
        else:
            user = User.objects.create(
                first_name=post_data["first"], 
                last_name=post_data["last"], 
                email=post_data["email"].lower(), 
                password=bcrypt.hashpw(post_data["password"].encode(), bcrypt.gensalt()), 
                date_of_birth=dob
            )
            return (True, user)

    def login(self, post_data):
        
        response = {
            "errors": [],
            "is_valid": True,
            "user": None
        }

        if len(post_data["email"]) < 1:
            response["errors"].append("Email is required")
        elif not EMAIL_REGEX.match(post_data["email"]):
            response["errors"].append("Invalid email")
        else:
            list_of_users_matching_email = User.objects.filter(email=post_data["email"].lower())
            if len(list_of_users_matching_email) < 1:
                response["errors"].append("Email does not exist")

        if len(post_data["password"]) < 1:
            response["errors"].append("Password is required")
        elif len(post_data["password"]) < 8:
            response["errors"].append("Password must be 8 characters or more")

        if len(response["errors"]) < 1:
            user = list_of_users_matching_email[0]
            if bcrypt.checkpw(post_data["password"].encode(), user.password.encode()):
                response["user"] = user
            else:
                response["errors"].append("Password is incorrect")

        if len(response["errors"]) > 0:
            response["is_valid"] = False

        return response

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    date_of_birth = models.DateTimeField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()




class TravelManager(models.Manager):
    def join(self, id, travel_id):
		
		joiner= User.objects.get(id=id)
		plan= self.get(id= travel_id)
		plan.tempo.add(joiner)
		return {}
    def travelvalidations(self, postData, id):
        errors=[]
        if len(postData['destination']) < 1 :
            errors.append("Destination field can not be empty")
        if len(postData['description']) < 1 :
            errors.append("Description field can not be empty")
       
        if str(date.today()) > str(postData['startdate']):
            errors.append("Start time can't be in the past")
        if str(date.today()) > postData['lastdate']:
            errors.append("Last date must be in the future")
        if postData['startdate'] > postData['lastdate']:
            errors.append("Travel Date From can not be in the future of Travel Date To")
        if len(errors) == 0:
            plan= Travel.objects.create(destination=postData['destination'],desc=postData['description'], startdate=postData['startdate'],enddate=postData['lastdate'], starter= User.objects.get(id=id))
            print "Successfully created new plan:"
            return (True, plan)
        else:
            print "Cannot input into Data"
            return (False, errors)
	def join(self, id, travel_id):
		
		joiner= User.objects.get(id=id)
		plan= self.get(id= travel_id)
		plan.tempo.add(joiner)
		return {}





class Travel(models.Model):
	destination = models.CharField(max_length = 255)
	desc = models.CharField(max_length = 255)
	startdate = models.DateField()
	enddate = models.DateField()
	starter = models.ForeignKey(User, related_name='planner')
	tempo = models.ManyToManyField(User, related_name='joiner')
	created_at = models.DateTimeField(auto_now_add=True)
	updated_at = models.DateTimeField(auto_now=True)
	objects = TravelManager()

    










