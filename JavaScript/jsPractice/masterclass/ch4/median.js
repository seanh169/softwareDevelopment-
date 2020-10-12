function median(values) {
    // console.log(values);
    if(values.length ===0) return 0;

    values.sort(function(a,b){
        return a-b;
    });

    var half = Math.floor(values.length / 2);

    if(values.length % 2 === 1) {
        return values[half];
    }
    
    return (values[half-1] + values[half]) / 2.0;
}


// let arr = [1,2,3];
// let obj = {0: '1', 1: '2', 2: '3'};
// for(let val of arr){
//     console.log(val);
// }
// for(let val in obj){
//     console.log(val);
// }

var data = [5, 2, 7, 9, 2, 3, 8, 4];
data.sort(function(a, b) {
  return b % 2 - a %2
});
console.log(data);

// console.log(median([1,2,3,4,5,6]));