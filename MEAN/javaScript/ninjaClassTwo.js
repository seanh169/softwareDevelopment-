class Ninja{
	constructor(name){
		this.name = name;
		this.health = 100;
		this.speed = 3;
		this.stregnth = 3;

	}
	sayName() {
		console.log(`This Ninja's name is ${this.name}`);
	}
	showStats(){
		console.log(`This Ninja's name is ${this.name}, Strength: ${this.strength}, Speed: ${this.speed}, Health: ${this.health}`);
	}
	drinkSake(){
		this.health += 10; 
	}
}
class Sensei extends Ninja {
	constructor(name){
		super(name);
		this.health = 200;
		this.speed = 10;
		this.strength = 10;

	}
	speakWisdom(){
		super.drinkSake();
		console.log("It is wise to learn to program.");
	}



}