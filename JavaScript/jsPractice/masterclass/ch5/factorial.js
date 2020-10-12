const {
    performance
  } = require('perf_hooks');

function factorial(n) {

    let factorial = n;
    for( let i = n-1; i > 0; i--) {
        factorial = factorial * i;
    }
    return factorial;

}

function recursiveFactorial(n) {
   if(n == 1) {
       return n;
   }

   return n * recursiveFactorial(n-1);
}

let t1 = performance.now();
console.log(factorial(10000))
let t2 = performance.now();

let t3 = performance.now();
console.log(recursiveFactorial(10000))
let t4 = performance.now();

console.log(`Iterate version took ${(t2-t1) / 1000} seconds `);
console.log(`recursive version took ${(t4-t3 ) / 1000} seconds `);