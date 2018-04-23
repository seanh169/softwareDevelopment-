function Ninja(name, health){
	let speed = 3;
	let strength = 3;
	this.name = name;
	this.health = 100;


	this.setSpeed = function(speed){this.speed = speed};
	this.getSpeed = function(){return speed};

	this.setStrength = function(stength){this.strength = strength};
	this.getStrength = function(){return strength};


	Ninja.prototype.sayName = function(){
		console.log("My name is : " + this.name);
	}
	Ninja.prototype.showStats = function(){
		console.log("Ninja Strength: " + this.getStrength() + " Ninja Speed: " + this.getSpeed() + " Ninja Health: " + this.health);


	}

	Ninja.prototype.drinkSake = function(){
		this.health = this.heatlh + 10;
		console.log(this.health);
	}
}
