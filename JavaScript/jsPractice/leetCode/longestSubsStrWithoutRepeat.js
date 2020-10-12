/**
 * @param {string} s
 * @return {number}
 */
// var lengthOfLongestSubstring = function(s) {
//     let arr = [];
//     let max = arr.length;
//     for(let i = 0; i < s.length; i++){
//         if(arr.includes(s[i])){
//             max = Math.max(arr.length, max);
//             arr = [];
//         }
//         arr.push(s[i]);
        
//     }
//     console.log(max);
// };
function findLongestSubstring(str) {
    let longest = 0;
    let seen = {};
    let start = 0;
   
    for (let i = 0; i < str.length; i++) {
      let char = str[i];
      if (seen[char]) {
        start = Math.max(start, seen[char]);
      }
      // index - beginning of substring + 1 (to include current in count)
      longest = Math.max(longest, i - start + 1);
      // store the index of the next char so as to not double count
      seen[char] = i + 1;
    }
    console.log(longest);
    return longest;
  }

var lengthOfLongestSubstring = function(s) {
    let max = s.length === 1 ? 1 : 0;
    let counter =  s.length > 0 ? 1 : 0;

    for(let i = 0; i< s.length; i++){
        for(let j = i+1; j < s.length; j++){
           if(s[i] !== s[j]){
               counter++;
               max = counter
           }else{
               max = counter;
           }

        }
    }
    console.log(max);

}
// lengthOfLongestSubstring("abcabcbb");
// lengthOfLongestSubstring("bbbbb");
// lengthOfLongestSubstring("pwwkew");
// lengthOfLongestSubstring(" ");
lengthOfLongestSubstring("dvdf");

// var ex = function(s) {
//     let arr = [];
//     if(s.length > 0){arr.push(s[0])};
//     let max = arr.length;
//     for(let i = 0; i < s.length; i++){
//         if(arr.includes(s[i])){
//             max = Math.max(arr.length, max);
//             arr = [];
//         }
//         arr.push(s[i]);
        
//     }
//     console.log(max);
// };
// ex(" ");
// let x = " ";
// let y = [];

// for(let i = 0; i < x.length; i++) {
//     y.push(x[i]);
// }
// console.log(x.length);
// console.log(y);
// console.log(y.includes(' '))