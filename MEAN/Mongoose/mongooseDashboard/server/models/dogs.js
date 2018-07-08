var path = require('path');
// Require Mongoose
var mongoose = require('mongoose');





// Mongoose to Conncet
mongoose.Promise = global.Promise;
// mongoose.connect("mongodb://localhost/dogs");
var DogSchema = new mongoose.Schema({
 name: { type: String, required: true},
 breed: { type: String, required: true},
 age: { type: Number, required: true},
 created_at: { type: Date, required: true, default: Date.now }
})



mongoose.model('Dog', DogSchema); // We are setting this Schema in our Models as 'User'
// var Dog = mongoose.model('Dog') // We are retrieving this Schema from our Models, named 'User'

module.exports = DogSchema