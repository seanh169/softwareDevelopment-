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
// Require Sessions
// var session = require('express-session');

// serving Angular
app.use(express.static( __dirname + '/routing-app/dist/' ));

// Enable/Use Session
// app.use(session({
//   secret: 'keyboardkitteh',
//   resave: false,
//   saveUninitialized: true,
//   cookie: { maxAge: 60000 }
// }))


app.all("*", (req,res,next) => {
  res.sendFile(path.resolve("./public/dist/public/index.html"))
});

app.listen(8000, function() {
 console.log("listening on port 8000");
});