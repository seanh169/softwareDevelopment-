var express = require("express");

var app = express();

app.set('views', __dirname + '/views'); 
app.use(express.static(__dirname + "/static"));
app.set('view engine', 'ejs');
app.use( express.static( "images" ) );

app.get('/cats', function(request, response) {

	response.render('cats');
	

})
app.get('/cats/madcat', function(request, response) {

	var cats_array = [
		{name: "MadCat", favoriteFood: "Pizza", age: 5, sleepingSpots: ["under the sun"," in the car"]},
		


	];
	
	response.render('details', {cats: cats_array});
	

})
app.get('/cats/lickcat', function(request, response) {

	var cats_array = [
		
		{name: "LickCat", favoriteFood: "Soup", age: 2, sleepingSpots: ["in a blanket", "in the bed"]},	
		


	];

	response.render('details', {cats: cats_array});
	

})
app.get('/cats/blackcat', function(request, response) {

	var cats_array = [
		
		{name: "blackCat", favoriteFood: "Steak", age: 9, sleepingSpots: ["on the couch", "on the tv"]}
		


	];

	response.render('details', {cats: cats_array});
	

})

app.listen(8000, function() {
  console.log("listening on port 8000");
})