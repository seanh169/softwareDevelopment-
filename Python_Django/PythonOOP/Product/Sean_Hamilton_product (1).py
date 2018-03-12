#<b><h1>Assignment: Product</b></h1>
#The owner of a store wants a program to track products. Create a product class to fill the following requirements.
#<b><h1>Product Class: </b></h1>
#<b><h2>Attributes</b></h1>


class product(object):
	def __init__(self, price, item_name, weight, brand):
		self.price = price
		self.item_name = item_name
		self.weight = weight
		self.brand = brand
		self.status = "for sale"
	def sell(self):
		self.status = "sold"
		return self
	def addTax(tax):
		self.price = self.price + (self.price * float(tax))
		return self
	def Return(self, reason):
		if reason == "defective":
			self.status = "defective"
		if reason == "new":
			self.status = "new"
		if reason == "used":
			self.status = "used"
			self.price = self.price - (self.price * 0.20)
		return self
	def displayInfo(self):
		print "Name of Product: " + str(self.item_name) + '\n' + "Price of product: " + str(self.price) + '\n' + "Weight of product is: " + str(self.weight) + '\n' + "Brand of product is: " + str(self.brand) + '\n' + "Status: " + str(self.status)

ipad = product(800, 'ipad', '2pounds', 'Apple')
ipad.displayInfo()
