const {
    performance
  } = require('perf_hooks');

function sumZero(arr) 
{

    // let returnArr = [];
    // for(let i = 0; i < arr.length; i++) {

    //     if(returnArr.length == 2){
    //         break;
    //     }
    //     let currentIndex = i;
    //     let firstValue = arr[i];

    //     for(let j = i+1; j < arr.length; j++) {
    //         if(firstValue + arr[j] == 0){
    //             returnArr.push(firstValue);
    //             returnArr.push(arr[j]);
    //         }
    //     }

    // }
    // let returnValue = returnArr.length == 2 ? returnArr : undefined
    // console.log(returnValue);
    // return returnValue; 

    let returnArr = [];
    let counter = 1;
    for(let i = 0; i < arr.length; i++) {
        if(returnArr.length == 2 || counter == arr.length){
            break;
        }

        let currentIndex = i;
        firstValue = arr[i];
        lastValue = arr[arr.length-counter];

        if(firstValue + lastValue == 0){
                returnArr.push(firstValue);
                returnArr.push(lastValue);
        }

        counter++;

    }
    let returnValue = returnArr.length == 2 ? returnArr : undefined
    console.log(returnValue);
    return returnValue;


}

sumZero([-3,-2,-1,0,1,2,3]);
sumZero([-2,0,1,3]);
sumZero([1,2,3]);