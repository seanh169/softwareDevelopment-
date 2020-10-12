/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {

    let longest = "";

    const isPalindrome = (s) => {
        return s.toLowerCase().split('').reverse().join('') === s;
    }
    for(let i = 0; i < s.length;i ++){
        let runningStr = "";
        runningStr += s[i];
        if(isPalindrome(runningStr)){
            if(runningStr.length > longest.length){
                longest = runningStr;
            }
        }
        for(let j = i+1; j < s.length; j++){
            runningStr += s[j];
            if(isPalindrome(runningStr)){
                if(runningStr.length > longest.length){
                    longest = runningStr;
                }
            }
        }
    }

    console.log(longest);
    
};

var longestPalindrome = function(s) {

    let longest = "";
    let last = s.length-1;
    const isPalindrome = (s) => {
        return s.toLowerCase().split('').reverse().join('') === s;
    }
    let runningStr = "";

    for(let i = 0; i < last;i++){
        runningStr = runningStr + s[i];
        if(isPalindrome(runningStr)){
            longest = runningStr.length > longest.length ? runningStr : longest;
        }
    }
    console.log(longest);


    
};

console.log(longestPalindrome("cbbd"))
console.log(longestPalindrome("babad"))

