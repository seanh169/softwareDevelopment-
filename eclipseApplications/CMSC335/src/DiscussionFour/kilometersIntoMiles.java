package DiscussionFour;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Thomas Culbertson
 * Week 4 Discussion
 * Simple GUI
 */
import javax.swing.JOptionPane;
 
public class kilometersIntoMiles {
    public static void main(String[] args) {
 
        String kmStr;   
        double km;      
        double mi;   
        
        //added - Discussion reply
        NumberFormat formatter = new DecimalFormat("#0.00");
 
        // Here is the Input
        kmStr = JOptionPane.showInputDialog(null, "Enter kilometers.");
        km = Double.parseDouble(kmStr);

        //Here is the Computation
        mi = km * 0.621;   

       
        
 
        //Here is the Output	//added - Discussion reply			
        JOptionPane.showMessageDialog(null, formatter.format(km) + " kilometers is "
                                          + formatter.format(mi) + " miles.");
    }
 
}

