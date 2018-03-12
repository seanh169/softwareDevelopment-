var HOUR = 7;
var MINUTE = 15;
var PERIOD = "PM";
if(PERIOD === "AM") {
	PERIOD = "in the morning.";
}
else if(PERIOD === "PM") {
	PERIOD = "in the evening.";
}
if(MINUTE < 30) {
	console.log("It's just after " + HOUR + " " + PERIOD);
}
else if(MINUTE > 30) {
	console.log("It's almost " + HOUR + " " + PERIOD);
}
