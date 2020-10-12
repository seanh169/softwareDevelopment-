let countUniqueValues = (arr) => {


    let returnObj = {};

    for(let val of arr) {
        returnObj[val] = (returnObj[val] || 0) + 1;

    }

    // console.log(returnObj);
    // console.log(Object.keys(returnObj).length);
    return Object.keys(returnObj).length;

}


countUniqueValues([1,1,1,1,1,2]);
countUniqueValues([1,2,3,4,4,4,7,7,12,12,13]);
countUniqueValues([]);
countUniqueValues([-2,-1,-1,0,1]);