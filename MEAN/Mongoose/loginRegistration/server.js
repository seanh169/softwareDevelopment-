let express  = require("express");
let mongoose = require("mongoose");
let bParse   = require("body-parser");
let session  = require("express-session");
let app      = express();
app.use(express.static(__dirname + "/client/static"));
app.use(bParse.urlencoded({ extended: true }));
app.use(session({secret:"hideme",
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}));
app.set("views",__dirname+"/client/views");
app.set("view engine","ejs");
app.listen(8080, function(){
	console.log('listening on port 8080');
});
require("./server/config/mongoose.js");
require("./server/config/routes.js")(app);