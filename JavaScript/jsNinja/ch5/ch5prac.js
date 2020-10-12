function Ninja(){
    var feints = 0;
    this.getFeints = function(){
        return feints;
    }
    this.setFeints = function(inputFeints){
        feints = inputFeints;
    }
    this.feint = function(){
        feints++;
    }
}

var ninja1 = new Ninja();

console.log(ninja1.getFeints());
ninja1.feint();
console.log(ninja1.getFeints());
ninja1.setFeints(5);
console.log(ninja1.getFeints());

class Card{

    constructor (suite, ) {
        this.suite = suite;
        
    }
}


// function sayHi(){
//     var var1 = 0;
//     this.xx = "x";
//     this.xy = function(){
//         return xx;
//     }
//     // console.log(arguments);
//     this.sayNo = function(){
//         var var2 = 1;
//         // console.log(var1 + " var2: " +  var2);
//         this.y = "y";
//         // console.log(this.xx);
//     }
//     // console.log(this);

// }
// var x = new sayHi();

// console.log(x.xx);