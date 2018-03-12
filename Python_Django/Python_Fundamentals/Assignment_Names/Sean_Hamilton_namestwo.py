#<b><h1>Assignment: Names</b></h1>
#Write the following function.
#<b>Part I</b>
#Given the following list:
students = [
     {
     'first_name':  'Michael',
     'last_name' : 'Jordan'
     },
     {
     'first_name' : 'John',
      'last_name' : 'Rosales'
      },
     {
     'first_name' : 'Mark',
      'last_name' : 'Guillen'
      },
     {
     'first_name' : 'KB',
      'last_name' : 'Tonel'}
]
'''Create a program that outputs:

Michael Jordan
John Rosales
Mark Guillen
KB Tonel
'''

for student in students:
	studentstring = ""
	for key in student:
		studentstring += student[key] + ' '
	print studentstring


#part2
#Now, given the following dictionary:
users = {
 'Students': [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
  ],
 'Instructors': [
     {'first_name' : 'Michael', 'last_name' : 'Choi'},
     {'first_name' : 'Martin', 'last_name' : 'Puryear'}
  ]
 }
def namesTwo():
	for user in users:
		print user
		count = 0
		for x in users[user]:
			nameString = ""
			count = count + 1
			for z in x.itervalues():
				nameString = nameString + " " + z
			print count, "-", nameString, "-", len(nameString)-2
namesTwo()










