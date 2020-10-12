/**
 * @param {string} str
 * @return {number}
 */
// var myAtoi = function(str) {
//     let inputString = str.trim().split('');
//     let output = "";

//     if(inputString[0] === '+' && inputString[1] === '-'){
//         return 0;
//     }

//     if(inputString[0] === '-' && inputString[1] === '+'){
//         return 0;
//     }

//     if(inputString[0] === '+'){
//         inputString.shift();
//     }



//     if(inputString[0] === '-' && inputString.length ===1 || inputString[0] === '-' && isNaN(inputString[1])) {
//         return 0;
//     }

   

//     if(inputString[0] === '-' || !(isNaN(inputString[0]))){
//         output += inputString[0];
//     }else{
//         return 0;
//     } 
    
//     for(let i = 1; i < inputString.length; i++){ 
//         if(!(isNaN(inputString[i]))){
//             output += inputString[i];
//         }else{
//             return Number.parseInt(output);
//         }
//     }
//     let returnValue = Number.parseInt(output);

//     if(returnValue > 2147483647){
//         return Math.pow(2, 31) - 1;
//     }

//     if(returnValue < -2147483647){
//         return Math.pow(-2, 31);
//     }

//     return returnValue;
    
// };

var myAtoi = function(str) {

    

    const RemoveStartingWhiteSpace =  (s) => {

        if(s.length === 0 || s[0] === '-' && s[1] === '+' || s[0] === '+' && s[1] === '-'){
            return 0;
        }

        for(let i = 0; i < s.length; i++) {
            if( (s[i] !== ' ' && (!isNaN(s[i]))) || (s[i] !== ' ' && (s[i] === '+' || s[i] === '-')) ){
                return s.split('').splice(i);
            }

            if(s[i] !== ' ' && (isNaN(s[i])) && s[i] !== '+' && s[i] !== '-' ){
                return 0;
            }
        }

        return 0;
    }

    let holder = RemoveStartingWhiteSpace(str);
   
    if(holder[0] === '+' && holder.length === 1 || holder[0] === '-' && holder.length === 1){
        return 0;
    }
    
    // console.log(holder);
    if(holder === 0){
        return 0;
    }
    let returnValue = Number.parseInt(holder.join(''))
    if(isNaN(returnValue)){
        return 0;
    }
    if(returnValue > 2147483647){
        return Math.pow(2, 31) - 1;
    }

    if(returnValue < -2147483647){
        return Math.pow(-2, 31);
    }
    return returnValue;
}

console.log(myAtoi("2147483648"));
// console.log(myAtoi("42"));
console.log(myAtoi("   -42"));
// console.log(myAtoi("4193 with words"));
console.log(myAtoi("words and 987"));
console.log(myAtoi("-91283472332"));
console.log(myAtoi(""));
console.log(myAtoi(" "));
console.log(myAtoi("-abc"));

// console.log(Math.pow(2, 31))