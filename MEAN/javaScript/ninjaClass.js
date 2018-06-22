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
	Ninja.prototype.punch = function(Ninja){
		let enemyninja = Ninja;
		enemyninja.health = enemyninja.health - 5; 
		console.log(enemyninja.name + " was punched by " + this.name + " and lost 5 health!");
	}
	Ninja.prototype.kick = function(Ninja) {
		let kickedNinja = Ninja;
		kickedNinja.health = kickedNinja.health - (15 * this.strength);
		
		console.log("The ninja preforming the kick has " + this.getStrength() + " strength");
		console.log(kickedNinja.name + " was kicked by " + this.name + " and lost 15 health!");
		console.log("In this case, redNinja " + kickedNinja.name + " lost 15 health because blueNinja " + this.name + " has " + this.getStrength() + " point of strength");
	}
}
