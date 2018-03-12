#<h1><b>Assignment: Stars</h1></b>
#Write the following functions.


#<b><h2>Part I</b></h2>
#Create a function called draw_stars() that takes a list of numbers and prints out *.

#For example
#x = [4, 6, 1, 3, 5, 7, 25]
#draw_stars(x) should print the following when invoked:
'''
****
******
*
***
*****
*******
*************************
'''
# def draw_stars(listofnumbers):
# 	for i in range(0,len(listofnumbers)):
# 		print "*"*listofnumbers[i]
# draw_stars([5,8,9])

def draw_stars(listofnumbers):
	for i in range(0,len(listofnumbers)):
		if type(listofnumbers[i]) == int:
			print "*"*listofnumbers[i]
		if type(listofnumbers[i]) == str:
			stringz = listofnumbers[i][0].lower()
			stringz = stringz * len(listofnumbers[i])

			print stringz



draw_stars([5,8,9])