function sameFrequency(intOne, intTwo){
    // good luck. Add any arguments you deem necessary.
    let arrOne = intOne.toString().split('');
    let arrTwo = intTwo.toString().split('');
    if(arrOne.length !== arrTwo.length) {
        return false;
    }

    arrOne.sort();
    arrTwo.sort();
    
   for(let i = 0 ; i < arrTwo.length; i++){
       if(arrOne[i] !== arrTwo[i]){
           return false;
       }
   }

   return true;
    
  }

console.log(sameFrequency(182, 281));
console.log(sameFrequency(34, 14));
console.log(sameFrequency(3589578, 5879385));
console.log(sameFrequency(22, 222));