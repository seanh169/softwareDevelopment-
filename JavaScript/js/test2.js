
// const fs = require('fs');
const readline = require('readline');
var path = require('path');
// console.log(process.argv[2]);
// console.log(process.argv[3]);
// for(let i =0; i< process.argv[3].length; i++){

// }

// var content;
// First I want to read the file
// fs.readFile('./x.txt', function read(err, data) {
//     if (err) {
//         throw err;
//     }
//     content = data;

//     // Invoke the next step here however you like
//     console.log(content);   // Put all of the code here (not the best solution)
//     // console.log(content);       // Or put the next step in a function and invoke it
// });
// var l;
// fs.readFile('./x.txt', 'utf8', function(err, data) {
//     if (err) throw err;
//     // console.log('OK: ' + filename);
//     // console.log(data);
//     l = data;
//     console.log(l[0])
//   });
//  let x = [];
//  let y = [];
// const readInterface = readline.createInterface({
//     input: fs.createReadStream('./x.txt'),
//     output: process.stdout,
//     console: false
// });
// readInterface.on('line', function(line) {
//     console.log(line);
//     x.push(line);
// });

// console.log(x[1]);
// const lineReader = require('line-reader');

// lineReader.eachLine('./x.txt', function(line) {
//     // console.log(line);
//     x.push(line);
//     console.log(x);
// });
// lineReader.open('/path/to/file', function(reader) {
//     if (reader.hasNextLine()) {
//         reader.nextLine(function(line) {
//             console.log(line);
//             x.push(line);
//         });
//     }
// });

// const lineByLine = require('n-readlines');
// const liner = new lineByLine('./x.txt');
// let line;
 
// while (line = liner.next()) {
//     console.log(toString);
// }
var jsonPath = path.join(__dirname, '..', 'x.txt');
var fs = require("fs");
var text = fs.readFileSync(jsonPath).toString('utf-8');
var textByLine = text.split("\n");
console.log(textByLine);