var daysUntilMyBirthday = 60;
for(var num = 60; num > 0; num-- ) {
	if(num > 30) {
		console.log(num + " days until my birthday. Such a long time........");
	}
	else if(num < 30 && num > 4) {
		console.log("ONLY " + num + " days until my birthday!");
	}
	else if(num < 5 && num > 0) {
		console.log(num + " DAYS UNTIL MY BIRTHDAY!!!!!");
	}
}