#<b><h1>Assignment: Making Dictionaries</b></h1>
'''Create a function that takes in two lists and creates a single dictionary. The first list contains keys and the second list contains the values. Assume the lists will be of equal length.

Your first function will take in two lists containing some strings. Here are two example lists:

name = ["Anna", "Eli", "Pariece", "Brendan", "Amy", "Shane", "Oscar"]
favorite_animal = ["horse", "cat", "spider", "giraffe", "ticks", "dolphins", "llamas"]

Here's some help starting your function.

def make_dict(list1, list2):
  new_dict = {}
  # your code here
  return new_dict

  '''
  #Hacker Challenge:
#If the lists are of unequal length, the longer list should be used for the keys, the #shorter for the values.

def make_dict(list1, list2):
	new_dict = dict(zip(list1, list2))
	print new_dict

make_dict([1,2,3],[4,5,6])