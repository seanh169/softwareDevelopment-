/*
BIG O of Objects in JavaScript:

Insertion - O(1)
Removal - O(1)
Searching - O(n) (Checking for specific value)
Access - O(1) (Checking for a key)



BIG O of built-in Object Methods:

Object.keys() - O(n)
Object.values() - O(n)
Object.entries() - O(n)
Object.hasOwnProperty() - O(1)

**/ 


let Sean = {

    firstName: "Sean",
    lastName: "Hamilton",
    favoriteNumbers: [1,2,3,4]

};


console.log(Object.keys(Sean));
console.log(Object.entries(Sean));