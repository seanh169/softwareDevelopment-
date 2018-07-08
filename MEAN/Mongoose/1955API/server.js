//Basic API Build


// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Require multer for file uploads
// Require path
var path = require('path');
// Integrate body-parser to return JSON data with our app
app.use(bodyParser.json()); 
// Require Sessions
var session = require('express-session');
// Enable/Use Session
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))
// setting up server connection/config
var mongoose = require('./server/config/mongoose.js')

var UserSchema = require('./server/models/1955.js')

require('./server/config/routes.js')(app)

















// tell the express app to listen on port 8000
app.listen(8000, function() {
 console.log("listening on port 8000");
});
