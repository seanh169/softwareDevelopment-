// Functions are first class Citizens - Which Means 3 things: 

// 1. Functions can be applied to variables,properties
const appliedVariable = function(){console.log('Function applied to variable')}


// 2. Functions can be passed as arguments to another function
function a() {console.log('I am function a')}
function b(fn) { console.log("I am function b which will run the function passed in as a parameter and the result of the passed in function is : "); fn()}
// b(a);


// 3. Functions can be returned as values
function c(){
    return function d(){console.log('Function D being returned from function c')}
}
c()()
// or
var z = c();
z()