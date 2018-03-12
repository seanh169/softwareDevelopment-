class Car(object):
	def __init__(self, price, speed, fuel, mileage):
		self.price = price
		self.speed = speed
		self.fuel = fuel
		self.mileage = mileage
		if self.price > 10000:
			self.tax = 0.15
		else: 
			self.tax = 0.12
		self.display_all()
	def display_all(self):
		print "Price: " +  str(self.price) + '\n' + "Speed: " + str(self.speed) + '\n' + "Fuel: " + str(self.fuel) + '\n' + "Mileage: " + str(self.mileage) + '\n' + "Tax: " + str(self.tax) + '\n'
				


pinto = Car(2000, "35mph", "Full", "15mpg")
ford = Car(20000, "20mph", "Not Full", "25mpg")
toyota = Car(50000, "70mph", "Half-Full", "30mpg")
nissan = Car(70000, "50mph", "Quarter Empty", "14mpg")
bmw = Car(90000, "80mph", "Three Quarters Full", "26mpg")
volkswagen = Car(80000, "65mph", "OverFull", "40mpg")
mercedes = Car(100000, "110mph", "Empty", "12mpg")
