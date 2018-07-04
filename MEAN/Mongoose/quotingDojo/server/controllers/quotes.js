const mongoose = require('mongoose'), 
      User = mongoose.model('User')

var quotes =  {index: function(req,res){res.render('index');}, adduser: function(req, res){
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
	// console.log(req.body);
	// res.render('quotes'); }
}, quotes: function(req, res){var quotes = User.find({}).sort('created_at').exec(function(err, users) {
				// console.log(users);
				var opp = users;

				// var newArray = users;
				// console.log(users);
 		// Retrieve an array of users
 		// console.log(users.sort());
 		res.render('quotes', {keke: opp});
		 // This code will run when the DB is done attempting to retrieve all matching records to {}
		})}
}

module.exports = quotes
