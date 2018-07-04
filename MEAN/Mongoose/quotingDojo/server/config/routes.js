
const mongoose = require('mongoose'), 
      User = mongoose.model('User')
mongoose.Promise = global.Promise;
module.exports = function(app){
var quotes = require('../controllers/quotes.js')
app.get('/', function(req, res) {
	   
    quotes.index(req, res);

  })

app.post('/adduser', function(req, res) {
  
    quotes.adduser(req, res);
})

app.get('/quotes', function(req, res) { 

	
  quotes.quotes(req, res);

	
})


}