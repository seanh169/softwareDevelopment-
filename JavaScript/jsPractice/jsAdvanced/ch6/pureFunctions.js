// Pure functions has two characteristics

// A function always has to return the same output given the same input

// A function cannot modify anything outside of itself - no side effects

const array = [1,2,3];

function a(arr) {
    let x = [...arr];
    x.pop();
    return x;
}

console.log(a(array));
console.log(array)