#<h1><b>Assignment: Compare Lists</h1></b>
'''Write a program that compares two lists and prints a message depending on if the inputs are identical or not.

Your program should be able to accept and compare two lists: list_one and list_two. 
If both lists are identical print "The lists are the same". 
If they are not identical print "The lists are not the same." 
Try the following test cases for lists one and two:
'''


def compareLists (listone, listwo):
	if set(listone) == set(listwo):
		print "The lists are the same"
	else :
		print "The lists are not the same"
# compareLists([1,2,5,6,2],[1,2,5,6,2])
# compareLists([1,2,5,6,5],[1,2,5,6,5,3])
compareLists([1,2,5,6,5,16],[1,2,5,6,5])
# compareLists(['celery','carrots','bread','milk'],['celery','carrots','bread','cream']
# )