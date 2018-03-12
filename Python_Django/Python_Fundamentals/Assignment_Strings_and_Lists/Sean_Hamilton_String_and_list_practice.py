#<b>Assignment: Strig and List Practice>/b>

#<b>Find and Replace</b>
#In this string: words = "It's thanksgiving day. It's my birthday,too!" print the position of the first instance #of the word "day". Then create a new string where the word "day" is replaced with the word "month".

words = "It's thanksgiving day. It's my birthday, too!"

for x in words
	print words.find('day')
	newString = words.replace("day", "month")
	print newString

#<b> Min and Max</b>
#Min and Max
#Print the min and max values in a list like this one: x = [2,54,-2,7,12,98]. Your code should work for any list.

minMax = []
	for x in minMax
		print min(minMax)
		print max(minMax)

#<b>First and last</b>
#First and Last
#Print the first and last values in a list like this one: x = ["hello",2,54,-2,7,12,98,"world"]. 
#Now create a new list containing only the first and last values in the original list. 
#Your code should work for any list.
x = ["hello",2,54,-2,7,12,98,"world"]
y = []

for i in x(0, -1) 
	y.append(x[0])
	y.append(x[-1])


print y


#<b>New List</b>
#Start with a list like this one: x = [19,2,54,-2,7,12,98,32,10,-3,6]. Sort your list first. 
#Then, split your list in half. Push the list created from the first half to position 0 of the list created from the second half. 
#The output should be: [[-3, -2, 2, 6, 7], 10, 12, 19, 32, 54, 98]. Stick with it, this one is tough!

x = [19,2,54,-2,7,12,98,32,10,-3,6]
x.sort()
new = [x[0:5]]
newEz = [x[5:11]]
newEzer = [new, newEz]
print newEzer




