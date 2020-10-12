//arguments and this passed to to all functions 
var assert = require('assert');
// function sum(){
//     var sum = 0;
//     for(var i = 0; i < arguments.length; i++) {
//         sum += arguments[i];
//     }
//     return sum;
// }

// console.log(sum(1, 2));
// console.log(sum(3, 4 , 5));


//re-written using rest parameter
// function sum(...inputArgs) {
//     var sum = 0;
//     for(var i = 0; i < inputArgs.length; i++) {
//         sum += inputArgs[i];
//     }
//     return sum;
// }

// console.log(sum(1, 2));
// console.log(sum(3, 4 , 5));


// function ninja(){
//     return this;
//     console.log(this);
// }

// function lilNinja () {
//     'use strict';
//     return this;
//     console.log(this);
// }



// var ninja1 = {
//     one: ninja

// }
// console.log(ninja1.one());
// console.log(ninja());

// function Ninja(){
//     this.skulk = function() {
//         return this;
//     }
// }
// var ninja1 = new Ninja();
// var ninja2 = new Ninja();

// var outerValue = 'ninja';
// function outerFunction(){
//     assert(outerValue === "ninja", "I can see the ninja.");
// }

// console.log(outerFunction());
// console.log(assert(5>4));

// function sayHello(){
//     'use strict';
//     this.hello = "hello";
//     this.sayHi = () => {
//         return this.hello;
//     }
// }

// function Emporer(){
//     'use strict';
//     this.rules = false;
//     console.log(this.rules);
//     // return this.rules;
// }

// function sayHello(){
//     this.hello = 'hello';
//     return this;
// }
// function sayHi(){
//     'use strict';
//     this.hello = 'hello';
//     // console.log(this);
//     return this;
// }
// var sayHo = () => {
//     this.hello = 'hello';
//     return this;
// }
// function sayHo (){
//     this.hello = "hello";
//     return this;
// }
// console.log(sayHello());
// console.log(sayHi());
// var x  = new sayHo();
// console.log(sayHo());
// console.log(x);

// var outerValue = "ninja";
// function outerFunction(){
//     if(outerValue === "ninja"){
//         return "I can see the ninja";
//     }
// }
// console.log(outerFunction());

function Ninja(){
    var fients = 0;
    this.getFients = function(){
        return fients;
    }
    this.feint = function(){
        feints++;
    }
}
var ninja1 = new Ninja();
console.log(ninja1.feints);
console.log(ninja1.getFients());