const maxSubarraySum = (inputArr, maxNumber) => {

    let max = 0;
    let temp = 0;
    if(inputArr.length < maxNumber) return null;

    for(let i = 0; i < maxNumber; i++) {
        temp += inputArr[i];
    }
    max = temp;

    for(let i = maxNumber; i < inputArr.length; i++) {
        // console.log(inputArr[i-maxNumber])
        temp = temp - inputArr[i-maxNumber] + inputArr[i];
        if(temp > max) {
            max = temp;
        }
    }

    console.log(max)


}

maxSubarraySum([1,2,3,5,6], 2)