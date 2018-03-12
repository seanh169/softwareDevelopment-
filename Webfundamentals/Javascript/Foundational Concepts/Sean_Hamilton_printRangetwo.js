function printRange(startPoint, endPoint, skipAmount) {
	var arr = startPoint;
	for(var i = startPoint; i < endPoint; i +=skipAmount) {
		arr = startPoint + skipAmount;
		console.log(i);
	}
	
}