/*
Use arrays when needing ORDER.

BIG O of arrays in JS:

Insertion - Push  = o(1). Inserting at beginning of Array = O(n)
Removal - Pop = O(1). Inserting at the beginning of Array = O(n)
Searching - O(n)
Access - O(1)


BIG of Built in Array methods in JS:

push - O(1)
pop - O(1)
shift - O(n)
unshift - O(n)
concat - O(n)
slice - O(n)
splice - O(n)
sort - O(nlogn)
forEach/Map/filter/reduce/ect - O(n)


**/



let testArr = ["hi", "hello", "sean"];

console.log(testArr.shift(0));
console.log(testArr);
console.log(testArr.unshift(1));
console.log(testArr);