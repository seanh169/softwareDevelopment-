#<b><h1>Assignment: Find Characters</b></h1>
'''Write a program that takes a list of strings and a string containing a single character, 
and prints a new list of all the strings containing that character.'''

def findCharacters(listed,singlechar):
        newArr = []
        
        for x in range(0,len(listed)):
            if listed[x].find(singlechar) != -1:
                newArr.append(listed[x])
        return newArr
        
print findCharacters(['hello', 'the'], 'l')
		# for i in listed:
		# 		listed[i]