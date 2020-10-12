// Higher order functions are functions that can take another function as a parameter or a function that returns another function

const multiplyBy = (x) => {
    return (y = 1) => {
        return x * y;
    }
}

const multiplyByTwo = multiplyBy(2);
console.log(multiplyByTwo(2))
console.log(multiplyByTwo(4))