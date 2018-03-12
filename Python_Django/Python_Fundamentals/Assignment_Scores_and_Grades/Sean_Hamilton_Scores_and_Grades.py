def scoresgrades():
	import random
	print "Scores and Grades"
	for x in range(1, 11):
		y= random.randint(60, 100)
		if(y>=60 and y < 70):
			print "Score : " + str(y) +  ";  Your grade is D"
		if(y>=70 and y<80):
			print "Score : " + str(y) +  ";  Your grade is C"
		if(y>=80 and y<90):
			print "Score : " + str(y) +  ";  Your grade is B"
		if(y>=90 and y<101):
			print "Score : " + str(y) +  ";  Your grade is A"
	print "End of the program. Bye!"		

scoresgrades()
		