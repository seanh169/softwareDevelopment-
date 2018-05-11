package person;

import person.HairColor.*;

public class Personz {
	HairColor haircolor = HairColor.BLACK;
	int age;
	
	Personz() {
		int age = 5;
	}
	Personz(HairColor hairColor){
		this.haircolor = hairColor;
		
	}
	public static void main(String[] args) {
		
		
		Personz peterParker = new Personz();
		Personz spiderMan = peterParker;
		spiderMan.age = 10;
		
		spiderMan.haircolor = HairColor.BLUE;
		
		
		
		System.out.println("Hair Color of Peter Parker: " + peterParker.haircolor);
		System.out.println("Hair Color of Peter Parker: " + spiderMan.haircolor);
		
		

		
	}
		

}
	
	

