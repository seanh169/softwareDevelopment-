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
mongoose.connect("mongodb://localhost/quotes");
var UserSchema = new mongoose.Schema({
 name: { type: String, required: true},
 quote: { type: String, required: true},
 created_at: { type: Date, required: true, default: Date.now }
})
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'


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
	// console.log(mongoose);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    res.render('index');
})

app.post('/adduser', function(req, res) {
	var user = new User({name: req.body.name, quote: req.body.quote});
	user.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong', err);
      for(var key in err.errors){
      		req.flash('registration', err.errors[key].message);
      }
      res.redirect('/');
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a user!');
      res.redirect('/');
    }
  	})
	console.log(req.body);
	// res.render('quotes');
})

app.get('/quotes', function(req, res) { 

	var quotes = User.find({}).sort('created_at').exec(function(err, users) {
				// console.log(users);
				var opp = users;

				// var newArray = users;
				// console.log(users);
 		// Retrieve an array of users
 		console.log(users.sort());
 		res.render('quotes', {keke: opp});
		 // This code will run when the DB is done attempting to retrieve all matching records to {}
		})

	
})

// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})