function validAnagram(inputOne, inputTwo) {

    if(inputOne.length !== inputTwo.length){
        return false;
    }
    let compareObjOne = {};
    let compareObjTwo = {};

    for(let val of inputOne) {
        compareObjOne[val] = (compareObjOne[val] || 0) + 1;
    }
    for(let val of inputTwo) {
        compareObjTwo[val] = (compareObjTwo[val] || 0) + 1;
    }

    for(let key in compareObjOne){
        if(!(key in compareObjTwo)){
            return false;
        }
        if(compareObjTwo[key] !== compareObjOne[key]){
            return false;
        }
    }
    return true;


}



console.log(validAnagram('', '')); // return true
console.log(validAnagram('aaz', 'zza')); // return false
console.log(validAnagram('anagram', 'nagaram')); // return true
console.log(validAnagram('rat', 'car')); // return false
console.log(validAnagram('awesome', 'awesom')); // return false
console.log(validAnagram('qwerty', 'qeywrt')); // return true
console.log(validAnagram('texttwisttime', 'timetwisttext')); // return true