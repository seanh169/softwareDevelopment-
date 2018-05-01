// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/basic_mongoose');

var UserSchema = new mongoose.Schema({
 name: {
 	type : String,
 	required : true
 },
 age : {
 	type : Number,
 	min : [21, "Yer too young kid."],
 	required : true
 }
})
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'

// create the express app
var app = express();
var bodyParser = require('body-parser');
// use it!
app.use(bodyParser.urlencoded({ extended: true }));
// static content
app.use(express.static(path.join(__dirname, "./static")));
// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view
app.get('/', function(req, res) {

 res.render("index");
})

app.get("/users", (req,res) => {
	User.find({}, (err, users) => {
		if (err) {
			console.log(err);
		} else {
			console.log(users);
		}
	});
})

app.get("users/detail", (req,res) => {
	User.findOne({email:req.body.email}, (err. user) => {
		if (err) {
			console.log(err);
		} else {
			console.log(user);
		}
	})
})

app.put("users/", (req,res) => {
	User.update({_id:req.body.id},)
})
// post route for adding a user
app.post('/users', function(req, res) {
  console.log("POST DATA", req.body);

  User.create({name: req.body.name, age: req.body.age}, function(err, user) {
  	if (err) {
  		console.log(err);
  	} else {
  		console.log(user);
  	}
  })
  // create a new User with the name and age corresponding to those from req.bodycopy
  // var user = new User({name: req.body.name, age: req.body.age});
  // // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
  // user.save(function(err) {
  //   // if there is an error console.log that something went wrong!
  //   if(err) {
  //     console.log('something went wrong');
  //   } else { // else console.log that we did well and then redirect to the root route
  //     console.log('successfully added a user!');
  //     res.redirect('/');
  //   }
  // })
})
// tell the express app to listen on port 8000
app.listen(8000, function() {
 console.log("listening on port 8000");
});