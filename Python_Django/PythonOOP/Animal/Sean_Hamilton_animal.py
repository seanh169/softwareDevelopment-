class animal(object):
	def __init__(self, name):
		self.name = name
		self.health = 100
	def walk(self):
		self.health = self.health - 1
		return self
	def run(self):
		self.health = self.health - 5
		return self
	def displayHealth(self):
		print str(self.health)
rat = animal("rat")
rat.walk().walk().walk().run().run().displayHealth()


class Dog(animal):
	def __init__(self, name):
		super(Dog, self)
		self.health = 150

	def pet(self):
		self.health = self.health + 5
		return self
dog = Dog("dog")

dog.walk().walk().walk().run().run().pet().displayHealth()

class Dragon(animal):
	def __init__(self, name):
		super(Dragon, self)
		self.health = 170
	def fly(self):
		self.health = self.health - 10
		return self
	def displayHealth(displayHealth):
		super(Dragon)
		print "I am a Dragon"
dr = Dragon("dragon")
dr.fly().displayHealth()

class Bird(animal):
	def __init__(self, name):
		self.health = 100






br = Bird("bird")
br.pet()