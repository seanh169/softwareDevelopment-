const mongoose = require('mongoose'), 
      Authors = mongoose.model('Authors')

      var authors = {index: function(req,res){

      	var authors = Authors.find({}, function(err, tasks){

      		// console.log(authors)
      		res.json(authors);
      	})


      },
      addAuthor: function(req, res){
      	let author = new Authors({name: req.params.name });author.save();res.redirect('/')
      }




  }

  module.exports = authors