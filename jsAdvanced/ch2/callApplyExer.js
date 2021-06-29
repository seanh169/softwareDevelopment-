
// var now = require("performance-now");
// const array = [1, 2, 3];

// const bigArr =  [];
// for(let i = 0 ; i < 100000; i++){
//     bigArr.push(i);
// }

// function getMaxNumber(arr) {
//     // return Math.max.call(getMaxNumber, ...arr)
//     return Math.max.apply(null, arr)
// }

// function maxNumber(arr) {
//     let max = Number.MIN_SAFE_INTEGER;
//     for(let i = 0; i < arr.length; i++) {
//         if(arr[i] > max){
//             max = arr[i]
//         }
//     }

//     return max;
// }

// // let start = now();
// // console.log(getMaxNumber(bigArr))
// console.time("hi")
// // getMaxNumber(bigArr)
// maxNumber(bigArr);
// console.timeEnd("hi")
// maxNumber(bigArr);
// let end = now();


// console.log((end - start).toFixed(3))
// console.log(Math.max(...array))

// function currying

// function multiply(a, b) { 
//     return a * b

// }

// let multiplyByTwo = multiply.bind(this, 
//     2)
//     console.log(multiplyByTwo(4))
const character = {
    name: 'Simon',
    getCharacter() {
        return this.name;
    }
};
const giveMeTheCharacterNOW = character.getCharacter.bind(character)

//How Would you fix this?
console.log('?', giveMeTheCharacterNOW()); 
//this should return 'Simon' bud doesn't
// console.log(character.getCharacter())