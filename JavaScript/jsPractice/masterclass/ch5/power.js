

function power(base, exponent){

    if(exponent == 0){
        return 1;
    }
    return base * power(base, exponent-1);


            
    
    
}
// console.log(power(2,0)) // 1
// console.log(power(2,2)) // 4
// console.log(power(2,4)) // 16



function factorial(n){
   
    if(n===1) {
        return 1;
    }
    // console.log(n * factorial(n-1));
    return  n * factorial(n-1);
}
console.log(factorial(1)); // 1
console.log(factorial(2)); // 2
console.log(factorial(4)); // 24
console.log(factorial(7)); // 5040