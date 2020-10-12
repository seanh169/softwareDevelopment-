// Currying

// Translating functions that take multiple parameters to functions that take one parameter at a time

// Example: 

const multiply = (a, b) => a*b;
const curriedMultiply = (a) => (b) => a*b;

console.log(curriedMultiply(3)(4))

// Partial Application - way to partially apply a function

// Example: 

