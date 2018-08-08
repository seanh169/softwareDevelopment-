const mongoose = require('mongoose'), 
      Cakes = mongoose.model('Cakes')

 var cakes =  {index: function(req,res){

	  var cakes = Cakes.find({}, function(err, cakes){

 		res.json(cakes);

	})







	}, 
	addCake: function(req, res){
		// console.log();
		console.log('yo');
		var cake = new Cakes({title: req.params.cakeTitle, URL: req.params.cakeURL});cake.save();res.redirect('/')

	},
	addNew: function(req, res){

		console.log('hello');

	},
	look: function(req, res){Cakes.find({_id: req.params.id}).lean().exec(function (err, users) {
		return res.json(users);

	})},
	remove: function(req, res){Cakes.deleteOne({ _id: req.params.id}, function(err){});res.redirect('/')},
	update: function(req, res){Cakes.findOneAndUpdate({ _id: req.params.id}, {$set: {title: req.params.newTitle, URL: req.params.newURL}}, function(err){}); res.redirect('/')},

}

module.exports = cakes