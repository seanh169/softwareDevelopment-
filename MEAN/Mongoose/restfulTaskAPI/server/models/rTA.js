var mongoose = require('mongoose');
mongoose.Promise = global.Promise;

var TaskSchema = new mongoose.Schema({
 title: { type: String, required: true},
 description: { type: String, required: true, default: ""},
 completed: { type: Boolean, default: false},
 createdAt: { type: Date, required: true, default: Date.now },
 updateAt: { type: Date, required: true, default: Date.now },
})

mongoose.model('Tasks', TaskSchema); 
module.exports = TaskSchema