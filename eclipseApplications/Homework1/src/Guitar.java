import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * 
 * File Name : Guitar.java
 * Author : Sean Hamilton
 * Date: 11/14/2018
 * Purpose of program: Design a Guitar class that has requested fields
 * and methods.
 * 
 *
 */

public class Guitar {
	//private fields
	private int numStrings = 6;
	private double guitarLength = 28.2;
	private String guitarManufacturer = "Gibson";
	private Color guitarColor = new Color (255, 0, 0);
	
	//empty Constructor
	public Guitar() {};
	
	//constructor
	public Guitar(int numStrings, double guitarLength, String guitarManufacturer, Color guitarColor) {
		
		this.numStrings = numStrings;
		this.guitarLength = guitarLength;
		this.guitarManufacturer = guitarManufacturer;
		this.guitarColor = guitarColor;
		
	}
	
	//Getter methods
	public int getNumStrings() {
		return numStrings;
	}

	public double getGuitarLength() {
		return guitarLength;
	}

	public String getGuitarManufacturer() {
		return guitarManufacturer;
	}

	public Color getGuitarColor() {
		return guitarColor;
	}
	
	//playGuitar requirement returns string representation
	public ArrayList<String> playGuitar() {
		
		String[] keys = {"A", "B", "C", "D", "E", "F", "G"};
		String[] notes = {"0.25", "0.5", "1", "2", "4"};
		ArrayList<String> results = new ArrayList<String>();
		
		for(int i = 0; i < 16; i++) {
			results.add(keys[new Random().nextInt(keys.length)] + "(" + notes[new Random().nextInt(notes.length)] + ")");

			
		}
		return results;
	}
	
	//guitarToString requirement displays data
	public void guitarToString(){
		
		System.out.println("(numStrings = " + this.numStrings + ", " + "Length = " + this.guitarLength + ", " + "manufacturer = " + this.guitarManufacturer + ", " + "color = " + Guitar.getColorName(this.guitarColor) + ")");
		
	}
	
	//Method to display text representation of rgb Color 
	public static String getColorName(Color c) {
	    for (Field f : Color.class.getFields()) {
	        try {
	            if (f.getType() == Color.class && f.get(null).equals(c)) {
	                return f.getName();
	            }
	        } catch (java.lang.IllegalAccessException e) {
	            // it should never get to here
	        } 
	    }
	    return "unknown";
	}
	
	

}
