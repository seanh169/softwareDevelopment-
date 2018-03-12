#<b><h1>Assignment: Making and Reading from Dictionaries</b></h1>
#Create a dictionary containing some information about yourself. The keys should include #name, age, country of birth, favorite language.
#Write a function that will print something like the following as it executes:
'''My name is Anna
My age is 101
My country of birth is The United States
My favorite language is Python'''

def dictionary ():
    new_dict = {
        'name': 'Sean', 
        'age': 31,
        'country': 'USA',
        'language': 'English'
    }
    
    print "My name is " + new_dict['name']
    print "MY age is " + str(new_dict[('age')])
    print "My country of birth is " + new_dict['country']
    print "My favorite language is " + new_dict['language']
dictionary()