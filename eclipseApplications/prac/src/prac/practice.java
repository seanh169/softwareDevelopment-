package prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice {
		static class Wheel {
			int size = 10;
		}
		static class rubberWheel extends Wheel {
			String material = "rubber";
			public rubberWheel() {
				this.material = "rubber";
			}
			
		}
		static class Battery {
			int age = 5;
		}
	
		static public class Car {
			public Car() {};
			public Wheel wh = new rubberWheel();
		}
	
		
		public static void main(String[] args) {
//			Wheel z = new rubberWheel();  
//			rubberWheel rb = new rubberWheel();
//			Car x = new Car();
//			System.out.println(x.wh.size);
////			System.out.println(rb.material);
			
			
		}



}



