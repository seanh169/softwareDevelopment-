// function Person(){
//     this.name = 'Sean';
//     this.age = 18;
    
// }
// Person.prototype.dance = () => {console.log("dancing")}

// function Ninja(){}
// Ninja.prototype = new Person();
// Ninja.prototype.attack = () => {console.log("attacking")}

// const ninja1 = new Ninja();
// ninja1.dance();
// ninja1.attack();
// // Object.defineProperty(Ninja.prototype, "constructor", {
// //     enumerable: false,
// //     value: Ninja,
// //     writable: true
// //   });
// console.log(Person.attack());


// const ninja = {
//     name : 'sean',
//     get ninjaName(){
//         return this.name;
//     },
//     set ninjaName(inputName){
//         this.name = inputName;
//     }
// }
// ninja.name = 'S';
// console.log(ninja.name);

function Ninja(){
    let _skillLevel = 0;

    Object.defineProperty(this, 'skillLevel', {
        get: ()=> _skillLevel,
        set: (value) => {
            _skillLevel = value;
        }
    })
}

Ninja.talk = () => {console.log('talk');}
let x = new Ninja();
x.skillLevel = 5;
console.log(x.skillLevel);
// console.log(Ninja.skillLevel);

