// var reverseVowels = function(s) {
//     const LEN = s.length;
//     const str = [...s];
//     const vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
//     const rev = [];
//     for (let i = 0; i < LEN; i++) {
//       if (vowels.includes(s[i])) { rev.push(s[i]); }
//     }
//     for (let i = 0; i < LEN; i++) {
//       if (vowels.includes(str[i])) { str[i] = rev.pop(); }
//     }
//     return str.join('');
//   };
// console.log(reverseVowels('alphanet'))

// let x = "hello";
// console.log(x.split("").sort())

let x = [
    {name: "sean", age: 37, height: 47},
    {name: "john", age: 27, height: 14},
    {name: "joe", age: 22, height: 64},
]

let y = x.map(item=>{
    return {title: item.name, yo: item.age}
})

console.log(y);