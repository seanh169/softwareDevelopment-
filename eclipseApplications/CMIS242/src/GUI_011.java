import javax.swing.*;
import java.awt.*;

public class GUI_011 extends JFrame {
  public GUI_011 () {
    this ("one");
  } // end no parameter constructor

  public GUI_011 (String t) {
    setTitle (t);
    setSize (200,200);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo (null);
    add (new JButton ("North " + t), BorderLayout.NORTH);
    add (new JButton ("East " + t), BorderLayout.EAST);
    add (new JButton ("West " + t), BorderLayout.WEST);
   
//     validate ();
    pack ();
    setVisible (true);
  } // end String constructor

  public static void main (String args []) {
    GUI_011 ga = new GUI_011 ();
    GUI_011 gb = new GUI_011 ("two");
  } // end main

} // end class GUI_01