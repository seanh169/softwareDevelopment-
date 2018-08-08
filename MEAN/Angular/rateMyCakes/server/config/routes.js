const mongoose = require('mongoose'),  
      Tasks = mongoose.model('Cakes')
mongoose.Promise = global.Promise;
module.exports = function(app){
var cakes = require('../controllers/cakes.js')
app.get('/cakes', function(req, res) {
	


	

	   
    cakes.index(req, res);

  })

app.get('/new/:cakeTitle/:cakeURL/', function(req, res) {
  	console.log('hell0')
    cakes.addCake(req, res);
})

app.get('/remove/:id', function(req, res) { 

	
  cakes.remove(req, res);

	
})
app.get('/:id', function(req, res) { 

	
  cakes.look(req, res);

	
})

app.get('/update/:id/:newTitle/:newURL/', function(req, res) { 

	
  cakes.update(req, res);

	
})

app.get('/cake', function(req, res) {
	console.log(newtask);
	tasks.addCake(req, res);
})

}