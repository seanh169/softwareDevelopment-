const mongoose = require('mongoose'),  
      Authors = mongoose.model('Authors') 
mongoose.Promise = global.Promise;

module.exports = function(app){
	var authors=require('../controllers/authors.js')

	app.get('/authors', function(req, res){



		authors.index(req, res);

	})
	
	app.get('/new/:name/', function(req, res){
		// console.log('hi')
		authors.addAuthor(req, res);
		// res.redirect('/');

	})

	app.get('/remove/:id', function(req, res) { 

	
  		authors.remove(req, res);

	
	})
	app.get('/update/:id/:newTitle/', function(req, res) { 

	
  		authors.update(req, res);

	
	})


	app.get('/:id', function(req, res) { 

	
  		authors.look(req, res);

	
	})






	


	}