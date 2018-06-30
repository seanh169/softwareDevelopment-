// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");
// require session
var session = require('express-session');
// create the express app
var app = express();

app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))

var bodyParser = require('body-parser');
// use it!
app.use(bodyParser.urlencoded({ extended: true }));
// static content
app.use(express.static(path.join(__dirname, "./static")));
// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');


app.get('/', function(req, res) {

	res.render('index');



})
app.post('/result', function(req, res){

	var formdata = req.body;
	console.log(req.body);
	res.render('result', {formzdata: formdata});

})










// tell the express app to listen on port 8000
app.listen(8000, function() {
 console.log("listening on port 8000");
});
