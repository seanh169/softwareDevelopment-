def coinTosses():
	import random
	tails = 0;
	heads = 0;
	for x in range(1, 5000):
		y=random.random()
		if y >= 0.5:
			tails = tails + 1
			print "Throwing a coin... It's a tails!... Got " + str(tails) + " tails(s) so far and " + str(heads) + " heads so far"
		if y < 0.5:
			heads = heads + 1
			print "Throwing a coin... It's a head!... Got " + str(heads) + " head(s) so far and " + str(tails) + " tails so far"
coinTosses()			