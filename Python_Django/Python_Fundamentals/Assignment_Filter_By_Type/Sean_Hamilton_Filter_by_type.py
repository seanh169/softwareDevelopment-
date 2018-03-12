#<b><h1>Assignment: Filter by Type</h1></b>
def filterByType (input):
    
    if type(input) == int:
        if input >= 100:
            print "That's a big number!"
        elif input < 100:
            print "That's a small number"
    elif type(input) == str:
        if len(input) >= 50:
            print "Long sentence"
        elif len(input) <= 50:
            print "Short sentence"    
    elif type(input) == list:
        if len(input) >= 10:
            print "Big List!"
        elif len(input) < 10:
            print "Short List."    
filterByType([1,2,3])