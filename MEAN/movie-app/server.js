//express

let express = require("express");
let app = express();

const path = require("path");

// Static Folder
app.use(express.static(__dirname + '/public/dist'));

//Body Parser
let bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());

//Morgan
let morgan = require("morgan");
app.use(morgan('dev'));

// MongoDB
let mongoose = require("mongoose");
mongoose.connect('mongodb://localhost/moviesSchema');

let MovieSchema = new mongoose.Schema({
	title: { type: String, require: true, minlength: [3, "Movie Title must be at least 3 characters."]},
	reviewer: { type: String, require: true, minlength: [3, "Your name needs to be at least 3 characters."]},
	stars: { type: String, require: true },
	reviews: { type: Array, require: true},
	editable: { type: Boolean, require: true}

})
mongoose.model("Movie", MovieSchema);
let Movie = mongoose.model("Movie");

//








//Routes

app.get("/movies", (req, res, next) => {
	console.log("Server > GET '/movies' ");
	Movie.find({}, (err, movies) =>{
		return res.json(movies);
	})
	// res.json([]);

})
//Create User
app.post("/movies", (req, res, next) => {
	console.log("Server > POST '/movies' > movie ", req.body);
	delete req.body._id;
	Movie.create(req.body, (err, movie) => {
		if (err) return res.json(err)
		else return res.json(movie)

	})

})

app.delete("/movies/:id", (req,res,next) => {
	console.log("Server > DELETE '/movies/:id/' ", req.params.id);
	Movie.deleteOne({_id: req.params.id}, (err, rawData) => {
		if (err) return res.json(err)
		else return res.json(true)
		console.log("status", status);
	})
})

app.get("/movies/:id", (req, res, next) => {
	console.log("Server > GET '/movies/:id/' ", req.params.id);
	Movie.get({_id:req.params.id}, req.body,(err, rawData) =>{
		if (err) return res.json(err)
		else return res.json(rawData)
	})
})

app.put("/movies/:id", (req, res, next) => {
	console.log("Server > PUT '/movies/:id/' ", req.params.id);
	Movie.update({_id:req.params.id}, req.body,(err, rawData) =>{
		if (err) return res.json(err)
		else return res.json(true)
	})
})

app.all("*", (req,res,next) => {
	res.sendfile(path.resolve("./public/dist/index.html"))

})


// Server Listening @ 1337
app.listen(1337, ()=> console.log("Server running at 1337"));