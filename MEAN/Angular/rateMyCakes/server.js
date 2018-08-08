//Rate My Cakes Application


// Require the Express Module
const express = require('express');
// Create an Express App
const app = express();
// Require body-parser (to receive post data from clients)
const bodyParser = require('body-parser');
// Require multer for file uploads
// Require path
const path = require('path');
// Integrate body-parser to return JSON data with our app
// app.use(bodyParser.json()); 
app.use(bodyParser.urlencoded({ extended: true }));


app.use(express.static( __dirname + '/cakes/dist/' ));

const mongoose = require('./server/config/mongoose.js')


const CakeSchema = require('./server/models/cakes.js')

require('./server/config/routes.js')(app)


// tell the express app to listen on port 8000
app.listen(8000, function() {
 console.log("listening on port 8000");
});