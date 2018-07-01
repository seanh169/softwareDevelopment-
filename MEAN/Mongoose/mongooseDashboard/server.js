// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
app.use(bodyParser.urlencoded({ extended: true }));
// Require path
var path = require('path');
var session = require('express-session');
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))

// Require Mongoose
var mongoose = require('mongoose');
// Mongoose to Conncet
mongoose.Promise = global.Promise;
mongoose.connect("mongodb://localhost/dogs");
// mongoose.Promise = global.Promise;
var DogSchema = new mongoose.Schema({
 name: { type: String, required: true},
 breed: { type: String, required: true},
 age: { type: Number, required: true},
 created_at: { type: Date, required: true, default: Date.now }
})
mongoose.model('Dog', DogSchema); // We are setting this Schema in our Models as 'User'
var Dog = mongoose.model('Dog') // We are retrieving this Schema from our Models, named 'User'


// Setting our Static Folder Directory
app.use(express.static(path.join(__dirname, './static')));
// Setting our Views Folder Directory
app.set('views', path.join(__dirname, './views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');
// Routes
// Root Request
const flash = require('express-flash');
app.use(flash());
app.get('/', function(req, res) {
	var dogs = Dog.find({}, function(err, dogs) {
		var xexe = dogs;

		res.render('index', {lol: xexe});
	})
	// console.log(mongoose);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    
})

app.get('/dogs/new', function(req, res) {
	// console.log(mongoose);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    res.render('newDog');
})

app.post('/dogs', function(req, res) {
	var dog = new Dog({name: req.body.name, breed: req.body.breed, age: req.body.age});
	dog.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong', err);
      for(var key in err.errors){
      		req.flash('registration', err.errors[key].message);
      }
      res.redirect('/');
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a dog!');
      res.redirect('/');
    }
  	})
	console.log(req.body);
	// res.render('quotes');
})

app.get('/dogs/:_id', function(req, res) {
	var thisDog = Dog.find({_id: req.params._id.slice(10, 34)}, function(err, dogs) {
		// var xx = req.params._id;
		// console.log(xx.slice(10, 34));
		// // console.log(xx);
		// console.log(req.params._id);
		// console.log(dogs);
 // Retrieve 1 object
 // This code will run when the DB is done attempting to retrieve 1 record.
 		var xexe = dogs;
	// console.log();
	// console.log(mongoose);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    res.render('specificDog', {dog: xexe});
	})

})
app.get('/dogs/edit/:_id', function(req, res) {
	
	var editDog = Dog.find({_id: req.params._id.slice(10, 34)}, function(err, dogs) {
		// var xx = req.params._id;
		// console.log(xx.slice(10, 34));
		// // console.log(xx);
		// console.log(req.params._id);
		// console.log(dogs);
 // Retrieve 1 object
 // This code will run when the DB is done attempting to retrieve 1 record.
 		var pepe = dogs;
	// console.log();
	// console.log(mongoose);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    res.render('editDog', {dog: pepe});
	})
    
})

app.post('/dogs/:_id', function(req, res) {
	console.log(req.params._id);
	Dog.update({_id: req.params._id.slice(10, 34)}, {$set: {name: req.body.name, breed: req.body.breed, age: req.body.age}}, function(err) {
	// console.log(err);
	// console.log(res.params._id);
	// console.log(req.body.name);	/
	// console.log(req.body.age);	
	// console.log(req.body.breed);	
	res.redirect('/');
	})

})

app.post('/dogs/destroy/:_id', function(req, res) {

	Dog.remove({_id: req.params._id.slice(10, 34)}, function(err){

			
	});
	res.redirect('/');	
})






































// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})