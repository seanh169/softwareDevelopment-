// const elf = {
//     name: 'Orwell',
//     weapon: 'bow',
//     attack() {
//         return 'attach with ' + elf.weapon
//     }
// }

// elf.name

// Object.create()

// Factory Functions
// Issue with below is that creating several Elf's will create several places in memory with the same attack functions

function createElf(name, weapon){
    return {
        name : name,
        weapon: weapon,
        attack() {
            return 'attack with ' + weapon
        }
    }
}

const peter = createElf("Peter", "stones")


// better way to save memory is to create prototype chain
const elfFunctions = {
    attack() { 
        return this.name + ' attacked with ' + this.weapon;
    }
}

function createBetterMemoryElf(name, weapon) {
    let newElf = Object.create(elfFunctions);
    newElf.name = name;
    newElf.weapon = weapon;
    return newElf;
}

const sean = createBetterMemoryElf('sean' ,'flamethrower');
// console.log(sean.attack())


// even better way - constructor functions
// constructor functions should start with capital E - let other programmers know
function ElfConstructorFunction(name, weapon) {
    this.name = name;
    this.weapon = weapon;
    this.attack = function () {
        return this.name + ' attacked with ' + this.weapon;
    }
}

// must use new with constructor function
const john = new ElfConstructorFunction('john' , 'stones');
const pam = new ElfConstructorFunction('pam' , 'balloons');
console.log(pam.attack())

// another way to do constructor fuunction
const CreateTheElf = new Function('name', 'weapon', `this.name = name; this.weapon = weapon`);

const joey = new CreateTheElf('joey', 'sword')
// console.log(joey)