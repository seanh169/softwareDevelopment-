function randomChance(quarters) {
	
	var winningamount = Math.floor(Math.random() * (100-50)) + 50;
	for(var i = quarters; i > 0; i--) {
		
		var winningchance = Math.floor(Math.random() * (100-1)) + 1;
		if( winningchance === 1 ) {
			quarters = quarters + winningamount;
			console.log('YOU WON');
		}
		else if(winningchance != 1 && winningchance > 0){
			quarters = quarters - 1;
			console.log("YOU LOST");
		}

	}
	return quarters;
}
randomChance(50)