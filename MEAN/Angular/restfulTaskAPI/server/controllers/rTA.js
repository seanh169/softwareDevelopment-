const mongoose = require('mongoose'), 
      Tasks = mongoose.model('Tasks')

      var tasks =  {index: function(req,res){

	  var tasks = Tasks.find({}, function(err, tasks){

 		res.json(tasks);

	})







	}, 
	addTask: function(req, res){
		// console.log();
		var task = new Tasks({title: req.params.taskTitle, description: req.params.taskDescription});task.save();res.redirect('/')

	},
	addNew: function(req, res){

		console.log('hello');

	},
	look: function(req, res){Tasks.find({_id: req.params.id}).lean().exec(function (err, users) {
		return res.json(users);

	})},
	remove: function(req, res){Tasks.deleteOne({ _id: req.params.id}, function(err){});res.redirect('/')},
	update: function(req, res){Tasks.findOneAndUpdate({ _id: req.params.id}, {$set: {title: req.params.newTitle, description: req.params.newDesc}}, function(err){}); res.redirect('/')},

}

module.exports = tasks