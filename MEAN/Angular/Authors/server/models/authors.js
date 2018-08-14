var mongoose = require('mongoose');
mongoose.Promise = global.Promise;

var AuthorSchema = new mongoose.Schema({
 name: { type: String, required: true, min: 3},
 // description: { type: String, required: true, default: ""},
 // completed: { type: Boolean, default: false},
 createdAt: { type: Date, required: true, default: Date.now },
 updateAt: { type: Date, required: true, default: Date.now },
})

mongoose.model('Authors', AuthorSchema); 
module.exports = AuthorSchema