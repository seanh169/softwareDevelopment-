#<h1><b>Assignment: Type List</h1></b>
'''Assignment: Type List
Write a program that takes a list and prints a message for each element in the list, based on that element's data type.

Your program input will always be a list. For each item in the list, test its data type. If the item is a string, concatenate it onto a new string. If it is a number, add it to a running sum. At the end of your program print the string, the number and an analysis of what the list contains. If it contains only one type, print that type, otherwise, print 'mixed'.

Here are a couple of test cases. Think of some of your own, too. What kind of unexpected input could you get?'''
def typeList(list1):   
        newString = "String is: "
        newSum = 0
        counter2 = 0
        counter1 = 0
        for i in range(len(list1)):
            if type(list1[i]) == str:
                newString = newString + " " + str(list1[i])
                counter1+=1
            if type(list1[i]) == int or type(list1[i]) == float: 
                newSum = (newSum) + float(list1[i])
                counter2+=1
        if counter2 > 0 and counter1 is 0:
            print "The list you entered is of integer type"
        elif counter2 is 0 and counter1 > 0:
            print "The list you entered is of string type"
        elif counter2 > 0 and counter1 > 0:
            print "The list you entered is of mixed type"
        print newString
        print "Sum: " + str(newSum)





# typeList([1,2,'hi',5]) 
typeList(['magical unicorns',19,'hello',98.98,'world'])
# typeList([2,3,1,7,4,12])
# typeList(['magical','unicorns'])
