function same(arrOne, arrTwo) {

    // Take in two arrays, and make sure the second array is the same as the first array except the values are squared. Order doesn't matter.

    // Inputs are two arrays - arrOne and arrTwo


    // output is boolean - true/false.

    // Can outputs be determined from inputs? ...

    // important parts - order doesnt matter, frequency, comparison.

    
    let compareArr = arrOne.map((x)=> {
        return x * x;
    })

    compareArr.sort();
    arrTwo.sort();
    let is_same = (compareArr.length == arrTwo.length) && compareArr.every(function(element, index) {
        return element === arrTwo[index];
    })
    return is_same;

}

console.log(same([1,2,3], [4,1,9]));
console.log(same([1,2,3], [1,9]));
console.log(same([1,2,1], [4,4,1]));