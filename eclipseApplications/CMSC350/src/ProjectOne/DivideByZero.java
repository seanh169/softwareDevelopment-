

package ProjectOne;

/**
 * 
 * 
 * File Name : DivideByZero.java
 * Author : Sean Hamilton
 * Date: 05/29/2019
 * Purpose of program: This class is an exception class, per requirements, that is used when a division by 0 occurs.
 * 
 * 
 *
 */

class DivideByZero extends Exception {

	  // Simple exception class that throws exception if there is a part of the algorithm that divides by 0.
	  DivideByZero(String alert) {
	    super(alert);
	  }



}
