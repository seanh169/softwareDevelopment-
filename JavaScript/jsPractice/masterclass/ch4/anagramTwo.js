function isAnagram(inputStringOne, inputStringTwo) {

    // Cinema & Iceman

    if(inputStringOne.length !== inputStringTwo.length) {
        return false;
    }

    let objOne = {};
    let objTwo = {};

    for(let val of inputStringOne.toLowerCase()) {
        objOne[val] = (objOne[val] || 0) + 1;
    }

    for(let val of inputStringTwo.toLowerCase()) {
        objTwo[val] = (objTwo[val] || 0) + 1;
    }

    console.log(objOne);
    console.log(objTwo);

    for(let val in objOne) {
        if(!(val in objTwo)){
            return false;
        }

        if(objOne[val] !== objTwo[val]){
            return false;
        }
    }

    return true;

}

console.log(isAnagram('Cinema', 'Iceman'));
console.log(isAnagram('zza', 'aza'));
console.log(isAnagram('zza', 'zaz'));
