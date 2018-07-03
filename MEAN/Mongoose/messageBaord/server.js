// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
app.use(bodyParser.urlencoded({ extended: true }));
// Require path
var path = require('path');
var session = require('express-session');
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))

// Require Mongoose
var mongoose = require('mongoose');
// Mongoose to Conncet
mongoose.Promise = global.Promise;
mongoose.connect("mongodb://localhost/message_board");
// mongoose.Promise = global.Promise;
var CommentSchema = new mongoose.Schema({
 name: { type: String, required: true},
 comment: { type: String, required: true},
 created_at: { type: Date, required: true, default: Date.now },
 
})



var PostSchema = new mongoose.Schema({
 name: { type: String, required: true},
 message: { type: String, required: true},
 created_at: { type: Date, required: true, default: Date.now },
 comments: [CommentSchema]
})
mongoose.model('Post', PostSchema); // We are setting this Schema in our Models as 'User'
var Post = mongoose.model('Post') // We are retrieving this Schema from our Models, named 'User'
mongoose.model('Comment', CommentSchema);
var Comment = mongoose.model('Comment')

// Setting our Static Folder Directory
app.use(express.static(path.join(__dirname, './static')));
// Setting our Views Folder Directory
app.set('views', path.join(__dirname, './views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');
// Routes
// Root Request
const flash = require('express-flash');
app.use(flash());


app.get('/', function(req, res) {
	var thispost = Post.find({}, function(err, posts) {
		var xexe = posts;

		res.render('index', {lol: xexe});
	})
	
})
app.post('/message', function(req, res) {
	var post = new Post({name: req.body.name, message: req.body.message});
	post.save(function(err) {
		console.log("SAVED");
		res.redirect('/');

	})


})
app.post('/comment/:id', function(req, res) {
	console.log(req.params.id);
	console.log(req.body.commentname);
	var newcomment = new Comment({name: req.body.commentname, comment: req.body.comment});
	Post.update({_id: req.params.id}, {$push: {comments: [newcomment]}}, function(err){
		console.log("UPDATE");
		res.redirect('/');
	})
	
	// res.redirect('/');
})









app.listen(8000, function() {
    console.log("listening on port 8000");
})