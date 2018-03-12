#<b><h1>Assignment: Dictionary in, tuples out</b></h1>
#Write a function that takes in a dictionary and returns a list of tuples 
#where the first #tuple item is the key and the second is the value. Here's an example:
'''# function input
my_dict = {
  "Speros": "(555) 555-5555",
  "Michael": "(999) 999-9999",
  "Jay": "(777) 777-7777"
}
#function output
[("Speros", "(555) 555-5555"), ("Michael", "(999) 999-9999"), ("Jay", "(777) 777-7777")]
copy
'''
def tuplesOut():
	my_dict = {
  "Speros": "(555) 555-5555",
  "Michael": "(999) 999-9999",
  "Jay": "(777) 777-7777"
}
	for x in my_dict:
		print my_dict.items()
tuplesOut()