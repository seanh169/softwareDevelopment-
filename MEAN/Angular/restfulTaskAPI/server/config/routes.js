const mongoose = require('mongoose'), 
      Tasks = mongoose.model('Tasks')
mongoose.Promise = global.Promise;
module.exports = function(app){
var tasks = require('../controllers/rTA.js')
app.get('/tasks', function(req, res) {
	


	

	   
    tasks.index(req, res);

  })

app.get('/new/:taskTitle/:taskDescription/', function(req, res) {
  	console.log('hell0')
    tasks.addTask(req, res);
})

app.get('/remove/:id', function(req, res) { 

	
  tasks.remove(req, res);

	
})
app.get('/:id', function(req, res) { 

	
  tasks.look(req, res);

	
})

app.get('/update/:id/:newTitle/:newDesc/', function(req, res) { 

	
  tasks.update(req, res);

	
})

app.get('/task', function(req, res) {
	console.log(newtask);
	tasks.addTask(req, res);
})

}