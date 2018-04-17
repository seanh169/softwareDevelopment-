//all parts of assignment

function zero_negativity(arr){
	counter = 0;
	for(var i = 0; i < arr.length; i++){
		if(arr[i] < 0){
			return false;
		}
	}
	return true;
}

function is_even(number){
	if(number%2 == 0){
		return true;
	}
	else{
		return false;
	}
}
function create_dummy_array(n){
	var newArr= []
	for(var i = 0 ; i < n ; i++){
		newArr.push(Math.floor(Math.random()*10));
	}
	return newArr;

}
function random_choice(arr){
	var m = Math.floor(Math.random()*(arr.length));
	console.log(arr[m]);
	
		

}