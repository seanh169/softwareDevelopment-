function maxSubarraySum(arr, num) {

    //Write a function that has max sum for num consecutive 

    // solution 1 o(n^2)
    //
    // let max = 0;
    // for(let i = 0; i < arr.length; i++){
    //     let currVal = 0;
    //     for(let j = 0; j < num; j++){
    //         // console.log(arr[i+j]);
    //         currVal += arr[i+j];
    //     }

    //     if(currVal > max){
    //         max = currVal;
    //     }


    // }
    // console.log(max);
    // return max;

    // solution 2 o(n)
 let maxSum =  0;
 let tempSum = 0;

 for(let i = 0; i < num; i++){
     maxSum += arr[i];
 }
 tempSum = maxSum;
 for(let i  = num; i < arr.length; i++) {
     tempSum = tempSum - arr[i-num] + arr[i];
     maxSum = Math.max(maxSum, tempSum);
 }
 return maxSum;
    
}
let sumArray = []
for(let i = 0 ; i < 100; i++){
    sumArray.push(i);
}
console.log(maxSubarraySum([1,2,3,4], 2));
console.log(maxSubarraySum([1,2,3,4,5,6], 3));
console.log(maxSubarraySum(sumArray, 2));

