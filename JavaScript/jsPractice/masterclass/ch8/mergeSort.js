// Time complexity O(nlogn)
// PseudoCode
// created in 1948



function mergeSort(arr) { 

    if(arr.length <= 1) { 
        return arr;
    }

    let mid = Math.floor(arr.length / 2);
    let leftSide = mergeSort(arr.slice(0, mid));
    let rightSide = mergeSort(arr.slice(mid));
    return merge(leftSide, rightSide);
}
function merge(arrOne, arrTwo) { 


    let returnArr = [];

    let counterOne = 0;
    let counterTwo = 0;

    while(counterOne < arrOne.length && counterTwo < arrTwo.length) {
        if(arrOne[counterOne] <= arrTwo[counterTwo]) {
            returnArr.push(arrOne[counterOne]);
            counterOne++;
        }
        if(arrOne[counterOne] >= arrTwo[counterTwo]) {
            returnArr.push(arrTwo[counterTwo]);
            counterTwo++;
        }

        
    }

    while(counterOne < arrOne.length){
        returnArr.push(arrOne[counterOne]);
        counterOne++;
    }
    while(counterTwo < arrTwo.length){
        returnArr.push(arrTwo[counterTwo]);
        counterTwo++;
    }
    return returnArr;

}



// console.log(merge([], [2,14,50,99,100]));
// console.log(mergeSort([10, 7 ,4, 5, 3, 1, 2]));
console.log(mergeSort([10,24,76,73]));