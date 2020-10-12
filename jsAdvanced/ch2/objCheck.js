const diff = require('deep-diff')


let obj1 = {
    name: 'Sean',
    age :42
}

let obj2 = {
    name: 'John',
    age: 30,
    del: 40
}

let obj3 = {
     name: 'John',
     age: 30,
     max: 40
}

function validateObjects(obj1, obj2) { 
    let obj1keys = Object.keys(obj1);
    let obj2keys = Object.keys(obj1);

    if(obj1keys.length !== obj2keys.length) return false;

    for(let objVal of obj1keys){
        // console.log(obj1[objVal])
        if(obj1[objVal] !== obj2[objVal]){
            return false;
        }
    }

    return true;



}

let differences = diff(obj2, obj3)

console.log(differences)

// console.log(validateObjects(obj2, obj3))