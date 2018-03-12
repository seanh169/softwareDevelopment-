function randomChance(quarters) { 
	var winner = 0;
	var winchance = Math.floor(Math.random() * (100-1)) + 1;
	var winamount = Math.floor(Math.random() * (100-50)) + 50;
	while(quarters > 0) {
		if(winchance === 1) {
		winner = winner + winamount;

	}
}
	return winner;
}




