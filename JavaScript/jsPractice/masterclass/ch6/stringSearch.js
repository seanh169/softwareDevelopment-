function stringSearch(stringOne, strTwo) {
    let matches = 0;
    for(let i = 0; i < stringOne.length; i++) {
        let outerLoopIterator = i;
        for(let j = 0 ; j < strTwo.length; j++) {

            
            let innerLoopIterator = j;
            
            if(innerLoopIterator == strTwo.length-1){
                matches += 1;
            }
            if(stringOne[outerLoopIterator] == strTwo[innerLoopIterator]) {
                outerLoopIterator++;
                innerLoopIterator++;

            }else{
                break;
            }
         }

    }

    return matches;


}


console.log(stringSearch('zomgz', 'omg'));
console.log(stringSearch('zomgzomgxxomg', 'omg'));
console.log(stringSearch('zomgzomgxxomg', 'pop'));