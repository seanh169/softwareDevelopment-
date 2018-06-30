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


// root route to render the index.ejs view
app.get('/', function(req, res) {

if(req.session.views){
	req.session.views++;
}else{
	req.session.views = 1;
}
var paws = req.session.views;
console.log(req.session.views);
console.log(req.session.views);
console.log(req.body.name);
req.session.name = req.body.name;
// console.log(req.session.name);

 res.render("index", {sessionCount: paws});
});
app.get('/plustwo', function(req, res) {
	req.session.views=req.session.views + 1;
	res.redirect('/');
})
app.get('/reset', function(req, res) {
	req.session.views = 0;
	req.session.destroy();
	res.redirect('/');
})

// tell the express app to listen on port 8000
app.listen(8000, function() {
 console.log("listening on port 8000");
});