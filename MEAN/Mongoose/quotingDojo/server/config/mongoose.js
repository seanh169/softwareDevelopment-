


var mongoose = require('mongoose');
// require('./server/models/quotes.js')(mongoose)
// // Mongoose to Conncet
mongoose.Promise = global.Promise;
mongoose.connect("mongodb://localhost/quotes");