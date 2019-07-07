package projectthree;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 
 * 
 * File Name : Fraction.java
 * Author : Sean Hamilton
 * Date: 06/26/2019
 * Purpose of program: Project 3 CMSC 350 UMUC. This class defines Fractions per project requirements. 
 * 
 * 
 *
 */

public class Fraction implements Comparable<Fraction> {

	private double data;
	private double top;
	private double bot;
	DecimalFormat df = new DecimalFormat();
	
	
	
	

	//constructor for a Fraction class that takes in a string representation as a fraction per project requirements.
	public Fraction(String inputFraction) {
		String[] splitFraction = inputFraction.split("/");
		this.top = Integer.parseInt(splitFraction[0]);
		this.bot = Integer.parseInt(splitFraction[1]);
		this.data = top/bot;
		
	}
	
	
	//Overridden compareTo Method for fraction comparison. Per project requirement.
	@Override
	public int compareTo(Fraction o) {
		int returnCompareValue = 0;
		if(this.data < o.getData()) {
			returnCompareValue = -5;
		}
		else if(this.data > o.getData()) {
			returnCompareValue = 5;
		}
		else if(this.data == o.getData()) {
			returnCompareValue= 0;
		}
		return returnCompareValue;
	}
	
	//Overridden toString method to display visual of fraction representation. 
	@Override
	public String toString() {
		String localTop = df.format(this.top);
		String localBot = df.format(this.bot);
		String fracVisual = localTop + "/" + localBot;
		return fracVisual;
	}
	
	
	//Getters and Setters
	public double getData() {
		return data;
	}


	public void setData(double data) {
		this.data = data;
	}


	public double getTop() {
		return top;
	}


	public void setTop(double top) {
		this.top = top;
	}


	public double getBot() {
		return bot;
	}


	public void setBot(double bot) {
		this.bot = bot;
	}
	


}
