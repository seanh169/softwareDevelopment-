const mongoose = require('mongoose'), 
      Authors = mongoose.model('Authors')

      var authors = {index: function(req,res){

      	var authors = Authors.find({}, function(err, authors){

      		console.log(authors)
      		res.json(authors);
      	})


      },
      addAuthor: function(req, res){
      	var author = new Authors({name: req.params.name });author.save();res.redirect('/authors')
      },
      remove: function(req, res){Authors.deleteOne({ _id: req.params.id}, function(err){});res.redirect('/')},
      update: function(req, res){Authors.findOneAndUpdate({ _id: req.params.id}, {$set: {name: req.params.newAuthor}}, function(err){}); res.redirect('/')},

      look: function(req, res){Authors.find({_id: req.params.id}).lean().exec(function (err, users) {
        return res.json(users);

      })},

  }

  module.exports = authors