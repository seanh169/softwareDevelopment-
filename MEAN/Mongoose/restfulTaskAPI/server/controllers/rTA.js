const mongoose = require('mongoose'), 
      Tasks = mongoose.model('Tasks')

      var tasks =  {index: function(req,res){

	  var tasks = Tasks.find({}, function(err, tasks){

 		res.json(tasks);

	})







	}, 
	addTask: function(req, res){
		var task = new Tasks({title: req.params.taskTitle, description: req.params.taskDescription});task.save();res.redirect('/')

	},
	look: function(req, res){Tasks.find({_id: req.params.id}).lean().exec(function (err, users) {
		return res.json(JSON.stringify(users));

	})},
	remove: function(req, res){Tasks.deleteOne({ _id: req.params.id}, function(err){});res.redirect('/')},
	update: function(req, res){Tasks.findOneAndUpdate({ _id: req.params.id}, {$set: {title: req.params.newTitle, description: req.params.newDesc}}, function(err){}); res.redirect('/')},

}

module.exports = tasks