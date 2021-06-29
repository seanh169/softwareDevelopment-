/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
    let leftValid = ["(", "[", "{"];
    let rightValid = [")", "]", "}"];
    if(rightValid.includes(s[0])){
        return false;
    }

    let stack = [];

    for(let i = 0; i < s.length; i++) {
        if(leftValid.includes(s[i])){
            let findIdx = leftValid.findIndex(x=>x === s[i]);
            stack.push(rightValid[findIdx]);
        }else{
            if(s[i] !== stack.pop()){
                return false;
            }
        }
    }
    return stack.length === 0;

};
console.log(isValid("]"))
console.log(isValid("()"))
console.log(isValid("()[]{}"))
console.log(isValid("(]"))
console.log(isValid("([)]"))
console.log(isValid("{[]}"))