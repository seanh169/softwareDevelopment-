// Load the express module and store it in the variable express (Where do you think this comes from?)
var express = require("express");
// console.log("Let's find out what express is", express);
// invoke express and store the result in the variable app
var app = express();
// app.set('views', __dirname + '/views');
app.use(express.static(__dirname + "/static"));
// app.get('/', function(request, response) {
//     // just for fun, take a look at the request and response objects
//    // console.log("The request object", request);
//    // console.log("The response object", response);
//    console.log(__dirname);
//    // use the response bject's .send() method to respond with an h1

//    app.use(express.static(__dirname + "/static"));
//    response.send("<h1>Hello Express</h1>");
// })


app.listen(8000, function() {
  console.log("listening on port 8000");
})