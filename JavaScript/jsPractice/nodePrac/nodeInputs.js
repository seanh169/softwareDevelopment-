process.stdin.resume();
process.stdin.setEncoding('utf8');
var util = require('util');
var input = "";

process.stdin.on('data', function (text) {
    input += text;
  });

process.stdin.on('end', function () {
    //do your processing here.
    lines = input.split("\n");
    let x = [];
    for(let i = 0; i < lines.length; i++) {
        x.push(lines[i].replace(/\r\n|\n|\r/gm,''))
    }
    let y = lines.filter(item=> {return item.trim() !== '' && item !== '\n'})
    // lines.replace()
  let z = y[2].split(" ").filter(item=> {return item.trim() !== ''});
    for(let i = 0; i < z.length; i++) {
        z[i] = Number.parseInt(z[i]);
    }
    console.log(z);
});