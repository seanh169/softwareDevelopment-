
//Basic 1
let x = [];
x.push("coding");
x.push("dojo");
x.push("rocks");
x.pop();
console.log(x); // logs ["coding", "dojo"]
//Basic 2
const y = [];
console.log(y);
y.push(88);
//returns 1 
//88 got pushed into the array

//Basic 3
let z = [9,10,6,5,-1,20,13,2];
for(i=0; i < z.length-1; i++){
	console.log(z[i]);
}

//Basic 4
let names = ['Kadie', 'Joe', 'Fritz', 'Pierre', 'Alphonso']
for(var i = 0; i < names.length; i++){
	if(names[i].length > 5){
	console.log(names[i]);
	}
}

//Basic 5
function yell(name){
	console.log(name.toUpperCase());
}