function sayA() {
    console.log('hi')
}

// sayA.apply();

const wizard = {
    name: 'Merlin',
    health: 100,
    heal(num1, num2){
        this.health += num1 + num2;
    },
    takeDmg(){ 
        this.health -= 25;
    }
}

const archer = { 
    name: 'Robin Hood',
    health: 30
}
console.log(archer)
const healArcher = wizard.heal.bind(archer, 50, 30)
console.log(archer)