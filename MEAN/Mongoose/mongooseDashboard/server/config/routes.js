const mongoose = require('mongoose'), 
      Dog = mongoose.model('Dog')
mongoose.Promise = global.Promise;
module.exports = function(app){
var dogz = require('../controllers/dogs.js')

app.get('/', function(req, res) {
	dogz.index(req, res);
    
})

app.get('/dogs/new', function(req, res) {
	dogz.newDog(req, res);
})

app.post('/dogs', function(req, res) {
	dogz.createDog(req, res);
})

app.get('/dogs/:_id', function(req, res) {
	dogz.specificDog(req, res);

})
app.get('/dogs/edit/:_id', function(req, res) {
	
	dogz.editDog(req, res);
    
})

app.post('/dogs/:_id', function(req, res) {
	dogz.updateDog(req, res);
})

app.post('/dogs/destroy/:_id', function(req, res) {

	dogz.destroyDog(req, res);


})

}