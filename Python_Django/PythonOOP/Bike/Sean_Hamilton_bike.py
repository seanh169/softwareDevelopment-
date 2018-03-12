#<b><h1>Assignment: Bike</b></h1>
#Create a new class called Bike with the following properties/attributes:
#

# class Bike(object):
# 	def __init__(self, price, max_speed):
# 		self.price = price
# 		self.max_speed = max_speed
# 		self.miles = 0
# 	def displayInfo(self):
# 		print "Price of bike is " + str(self.price) + " dollars."
# 		print "Max Speed of bike is " + str(self.max_speed) + "miles per hour"
# 		print 'Miles on bike ' + str(self.miles) 
# 		return self
# 	def ride(self):
# 		print "Riding"
# 		self.miles = self.miles + 10
# 		return self
# 	def reverse(self):
# 		print "Reversing"
# 		self.miles = self.miles - 5
# 		return self





















class User(object):
	def __init__(self, price, max_speed):
		self.price = price
		self.max_speed = max_speed
		self.miles = 0
	def displayInfo(self):
		print "The bike's price is " + str(self.price)
		print "The maximum speed of this bike is " + self.max_speed
		print "This bike currently has " + str(self.miles) + "miles"
		return self
	def ride(self):
		print "Riding"
		self.miles = self.miles + 10
		return self
	def reverse(self):
		print "Reversing"
		if self.miles >= 5:
			self.miles = self.miles -  5
		return self
sean = User(200, "10mph")
john = User(100, "20mph")
paul = User(50, "5mph")
sean.ride().ride().ride().reverse().displayInfo()
john.ride().ride().reverse().reverse().displayInfo()
paul.reverse().reverse().reverse().displayInfo()


































