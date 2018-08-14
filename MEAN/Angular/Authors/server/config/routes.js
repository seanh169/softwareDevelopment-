const mongoose = require('mongoose'),  
      Authors = mongoose.model('Authors') 
mongoose.Promise = global.Promise;

module.exports = function(app){
	var authors=require('../controllers/authors.js')

	app.get('/authors', function(req, res){



		authors.index(req, res);

	})
	












	


	}