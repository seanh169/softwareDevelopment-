//Authors Full CRUD App with Angular, Express, Node, MongoDB

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
// app.use(bodyParser.json()); 
app.use(bodyParser.urlencoded({ extended: true }));


// serving Angular
app.use(express.static( __dirname + '/authors-app/dist/' ));


var mongoose = require('./server/config/mongoose.js')

var AuthorSchema = require('./server/models/authors.js')

require('./server/config/routes.js')(app)

app.all("*", (req,res,next) => {
  res.sendFile(path.resolve("./public/dist/public/index.html"))
});
// tell the express app to listen on port 8000
app.listen(8000, function() {
 console.log("listening on port 8000");
});