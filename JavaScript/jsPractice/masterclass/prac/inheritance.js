class Dog {
    constructor(name){
        this.name = name;
        this.type = 'Dog'
    }

    sayName(){
        console.log('hi I am a dog');
    }
}

class Pitbull extends Dog {
    // construco
    constructor(name){
        super(name);
        this.type = 'Pitbull';
    }

    sayName(){
        console.log('hi I am a pitbull');
    }
}

class Chi extends Pitbull {

}

let x = new Pitbull("sean");
let  y = new Chi();
// x.sayName();
// console.log(x.name);
// console.log(x.type);
y.sayName();