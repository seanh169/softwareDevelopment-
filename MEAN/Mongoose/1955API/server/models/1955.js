var mongoose = require('mongoose');
mongoose.Promise = global.Promise;

var UserSchema = new mongoose.Schema({
 name: { type: String, required: true},
 createdAt: { type: Date, required: true, default: Date.now },
 updateAt: { type: Date, required: true, default: Date.now },
})
// mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
module.exports = UserSchema