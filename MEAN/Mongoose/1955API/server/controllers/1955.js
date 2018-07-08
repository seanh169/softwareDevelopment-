const mongoose = require('mongoose'), 
      User = mongoose.model('User')

var people =  {index: function(req,res){

var person = User.find({}, function(err, users){

 res.json(users);

})}, 




 



adduser:  function(req,res){var user = new User({name: req.params.name});user.save();console.log("ADDED");res.redirect('/')},
remove: function(req, res){User.deleteOne({ name: req.params.name }, function(err){}); res.redirect('/')},
look: function(req, res){User.find({name: req.params.name}).lean().exec(function (err, users) {
    return res.json(JSON.stringify(users));
})}, 


}

module.exports = people