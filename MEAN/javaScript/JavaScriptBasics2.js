function magic_multiply(x, y){
	if(typeof(x) == "object" ){
		for(var i = 0 ; i < x.length; i++){
			x[i] = x[i] * y;

		}
		y = y * x.length;
	}

	else{return x * y;}
}