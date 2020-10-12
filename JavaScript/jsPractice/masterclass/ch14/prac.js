// let hello = "Hello I would Like to Work at Amazon";

// function reverseStr (str) {

//     let splitStr = str.split(' ');
//     let returnStr = "";
//     for(let i = splitStr.length-1 ; i >= 0; i--) {
//         // console.log(splitStr[i]);
//         returnStr += splitStr[i] + " ";
//     }
//     console.log(returnStr);

// }

// reverseStr(hello);



// let unsortedIntArray = [5, 3, 6, 9, 10, 10];

// function findDuplicate(arr) {
    
//     let obj = {};

//     for(let i = 0; i < arr.length; i++) {

//         obj[arr[i]] = obj[arr[i]] ?  i : "justone";
//         if(obj[arr[i]] !== "justone") {
//             return arr[i];
//         }


//     }
//     // return obj;
// }

// console.log(findDuplicate(unsortedIntArray));

// let paramArr = [1,2,3];
// let tot = 4;

// function sumTotal(arr, total) { 

//     for(let i = 0; i < arr.length - 1; i++) {
//         for(let j = 1; i < arr.length; j++) {
//             if(arr[i] + arr[j] === total) { 
//                 return [arr[i], arr[j]];
//             }
//         }
//     }

// }

// console.log(sumTotal(paramArr, tot));

function count(n) {
    if (n === 1) {
      return [1];
    } else {
      var numbers = count(n - 1); 
      numbers.push(n);
      return numbers;
    }
  }
console.log(count(5));