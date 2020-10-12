const {
    performance
  } = require('perf_hooks');

function summation(n) {
    let total = 0;

    for(let i = 0; i <= n; i++){
        total += i;
    }

    return total;

}

function summationTwo(n) { 

    return n * (n + 1) / 2;

}


let time1 = performance.now();
summation(10000000000);
let time2 = performance.now();

let time3 = performance.now();
summationTwo(10000000000);
let time4 = performance.now();

// console.log(summationTwo(100));

console.log(`Time Elapsed for summation loop: ${(time2-time1) / 1000} seconds`);
console.log(`Time Elapsed for summation loop: ${(time4-time3) / 1000} seconds`);