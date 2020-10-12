// for documentation and examples, check out: nodemailer.com
var nodemailer = require("nodemailer");
​
var transporter = nodemailer.createTransport({
	host: "mailhost.gsfc.nasa.gov",
	port: 25,
	secure: false,
    tls: {
      // complains about invalid certs? // TODO: would be more secure if we fixed this?
      rejectUnauthorized: false
    }
});
​
transporter.verify((err, success) => {
	if (err) {
		console.log("Node transporter connection error.");
	} else {
		console.log("Node transporter connected!");
	}
});
​
// example usage
transporter.sendMail({
    from: `no-reply@example.com`,
    to: `sean.j.hamilton@nasa.gov`,
    subject: "Hello ✔",
    text: "Hello world?",
    html: "<b>Hello world?</b>"
});