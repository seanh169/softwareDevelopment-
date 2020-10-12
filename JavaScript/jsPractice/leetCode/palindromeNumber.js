var isPalindrome = function(x) {
    let reverse = ("" + x + "").split('').reverse().join('');

    // return x === reverse;
    console.log(x.toString() === reverse)
};

isPalindrome(121)
isPalindrome(50001)
isPalindrome(-50001)