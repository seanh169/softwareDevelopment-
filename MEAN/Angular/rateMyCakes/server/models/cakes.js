const mongoose = require('mongoose');
mongoose.Promise = global.Promise;


const CakeSchema = new mongoose.Schema({
 title: { type: String, required: true},
 URL: { type: String, required: true, default: ""},
 // completed: { type: Boolean, default: false},
 createdAt: { type: Date, required: true, default: Date.now },
 updateAt: { type: Date, required: true, default: Date.now },
})

mongoose.model('Cakes', CakeSchema); 
module.exports = CakeSchema