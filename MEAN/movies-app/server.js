//express

let express = require("express");
let app = express();

// MongoDB
let mongoose = require("mongoose");
mongoose.connect('mongodb://localhose/moviesSchema');

//
const path = require("path");

//Body Parser
let bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());

// Static Folder