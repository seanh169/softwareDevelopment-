const http = require('http');
const nodemailer = require("nodemailer");
const path = require('path');
const fs = require("fs");


const hostname = '127.0.0.1';
const port = 3000;
process.argv.splice(0, 2);
const messageLength = process.argv.length;
const branch =  process.argv.slice(1,2).join(" ");
const revisionNumber =process.argv.slice(0,1).join(" ");
const optionalMessage = process.argv.slice(2,messageLength).join(" ");

let jsonPath = path.join(__dirname, '..', 'changelist.txt');

let text = fs.readFileSync(jsonPath).toString('utf-8');
let textByLine = text.split("\n");
let messageTo = 'terri.a.hairell@nasa.gov,viktor.kopit@nasa.gov,nicholas.a.elisio@nasa.gov,xiaofu.xie-1@nasa.gov,kevin.ma@nasa.gov,tairbek.s.pazylbekov@nasa.gov,sean.j.hamilton@nasa.gov';
// let messageTo = 'sean.j.hamilton@nasa.gov';


let message = 'Hi All, <br><br> I have pushed some changes to <b>' + branch + '</b> branch and the revision number is <b>' + revisionNumber+  '</b>. Tairbek, when you have time, if you could please merge to TEST/UAT. <br><br>Changes are related to: <br><br><b>' + optionalMessage + '</b><br><br>Thank you! <br> Here is the file change list: <br><br>';
for(let i = 0; i< textByLine.length; i++){
    message = message + textByLine[i] + "<br>";
}
let footer = '<br><br><b>Sean J. Hamilton<br>Computing & Communications Division - Code 720<br>NASA – Goddard Space Flight Center<br>Phone: 301-286-2892<br>Email: Sean.J.Hamilton@nasa.gov</b><br><br><br>';
let totalMessage = message + footer;



var transporter = nodemailer.createTransport({
	host: "mailhost.gsfc.nasa.gov",
	port: 25,
	secure: false,
    tls: {
      // complains about invalid certs? // TODO: would be more secure if we fixed this?
      rejectUnauthorized: false
    }
});
transporter.verify((err, success) => {
	if (err) {
		console.log("Node transporter connection error.");
	} else {
		console.log("Node transporter connected!");
	}
});

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World\n');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
  transporter.sendMail({
    from: `Sean.J.Hamilton@nasa.gov`,
    to: messageTo,
    subject: revisionNumber,
    text: 'textByLine',
    html: totalMessage
    }, (err,info) => {
        console.log(err);
    });
    server.close();
});