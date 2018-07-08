const mongoose = require('mongoose'), 
      User = mongoose.model('User')
mongoose.Promise = global.Promise;
module.exports = function(app){
var people = require('../controllers/1955.js')
app.get('/', function(req, res) {
	


	

	   
    people.index(req, res);

  })

app.get('/new/:name/', function(req, res) {
  	
    people.adduser(req, res);
})

app.get('/remove/:name', function(req, res) { 

	
  people.remove(req, res);

	
})
app.get('/:name', function(req, res) { 

	
  people.look(req, res);

	
})

}