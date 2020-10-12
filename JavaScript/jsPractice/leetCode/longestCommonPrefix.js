/**
 * @param {string[]} strs
 * @return {string}
 */


// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".


var longestCommonPrefix = function(strs) {
    

    let longestPrefix = '';
    if (strs.length < 1) return longestPrefix;
    if (strs.length === 1) return strs[0];

    let compareIdx = 0;

    for(let i = 0 ; i < strs[0].length; i++) {


        for(let j = 1; j< strs.length; j++) {
            let curWord = strs[j];
            let curLetter = curWord.charAt(compareIdx);
            if(strs[0][i] !== curLetter || compareIdx > curWord.length) {
                return longestPrefix;
            }


        }

        compareIdx++;
        longestPrefix += strs[0][i];
    }
};

// longestPrefix = '';
// comapreIdx = 0;

// curWord = "flow"
// curLetter = "f"

// ----

// compareIdx = 1
// longestPrefix = 'f'

// curWord = 'flow'
// curLetter = 'l'


console.log(longestCommonPrefix(["flower","flow","flight"]));
console.log(longestCommonPrefix([""]))