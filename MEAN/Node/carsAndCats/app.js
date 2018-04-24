// get the http module:
var http = require('http');
// fs module allows us to read and write content for responses!!
var fs = require('fs');
// creating a server using http module:
var server = http.createServer(function (request, response){
    // see what URL the clients are requesting:
    console.log('client request URL: ', request.url);
    // this is how we do routing:
    if(request.url === '/cars') {
        fs.readFile('cars.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html' }) ;
            // response.writeHead(200, {'Content-Type': 'text/css' });  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    else if(request.url === '/cats') {
        fs.readFile('cats.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html' }) ;
            // response.writeHead(200, {'Content-Type': 'text/css' });  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    else if(request.url === '/images/audi.jpeg') {
        fs.readFile('./images/audi.jpeg', function (errors, contents){
            // console.log(contents)
            response.writeHead(200, {'Content-Type': 'image/jpeg'}) ;
            // response.writeHead(200, {'Content-Type': 'text/css' });  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    else if(request.url === '/images/whitecar.jpeg') {
        fs.readFile('./images/whitecar.jpeg', function (errors, contents){
            // console.log(contents)
            response.writeHead(200, {'Content-Type': 'image/jpeg'}) ;
            // response.writeHead(200, {'Content-Type': 'text/css' });  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    else if(request.url === '/images/cat.jpeg') {
        fs.readFile('./images/cat.jpeg', function (errors, contents){
            // console.log(contents)
            response.writeHead(200, {'Content-Type': 'image/jpeg'}) ;
            // response.writeHead(200, {'Content-Type': 'text/css' });  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    else if(request.url === '/images/catz.jpeg') {
        fs.readFile('./images/catz.jpeg', function (errors, contents){
            // console.log(contents)
            response.writeHead(200, {'Content-Type': 'image/jpeg'}) ;
            // response.writeHead(200, {'Content-Type': 'text/css' });  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    else if(request.url === '/cars/new') {
        fs.readFile('newCar.html', 'utf8', function (errors, contents){

            response.writeHead(200, {'Content-Type': 'text/html' }) ;
            // response.writeHead(200, {'Content-Type': 'text/css' });  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    // request didn't match anything:
    else {
        response.writeHead(404);
        response.end('File not found!!!');
    }
});
// tell your server which port to run on
server.listen(7077);
// print to terminal window
console.log("Running in localhost at port 7077");