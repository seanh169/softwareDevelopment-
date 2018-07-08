const mongoose = require('mongoose'), 
      Dog = mongoose.model('Dog')
const fs = require('fs')
// img path
var imgPath = '../';

var dogz = { index: function(req, res) {
	var dogs = Dog.find({}, function(err, dogs) {
		var xexe = dogs;

		res.render('index', {lol: xexe});
	})}, newDog: function(req, res) {
	// console.log(mongoose);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    res.render('newDog');
	}, createDog: function(req, res) {
	console.log(req.body);	
	var dog = new Dog({name: req.body.name, breed: req.body.breed, age: req.body.age});
	dog.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong', err);
      for(var key in err.errors){
      		req.flash('registration', err.errors[key].message);
      }
      res.render('newDog');
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a dog!');
      res.redirect('/');
    }
  	})
	console.log(req.body);
	// res.render('quotes');
	}, specificDog: function(req, res) {
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

	}, editDog: function(req, res) {
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




	}, updateDog: function(req, res) {
	// console.log(req.params._id);
	Dog.update({_id: req.params._id.slice(10, 34)}, {$set: {name: req.body.name, breed: req.body.breed, age: req.body.age}}, function(err) {
	
	res.redirect('/');
	})

	}, destroyDog: function(req, res) {

	Dog.remove({_id: req.params._id.slice(10, 34)}, function(err){

			
	});
	res.redirect('/');	
	}
	// console.log(mongoose);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    










}



















module.exports = dogz