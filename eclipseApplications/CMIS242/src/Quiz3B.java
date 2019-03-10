
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz3B extends JFrame implements ActionListener
{
   private JButton okButton = new JButton("OK");

   public Quiz3B()
   {
       add(okButton);
       okButton.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e)
   {
       System.out.println("The OK button is clicked");
   }

   public static void main(String[] args)
   {
       JFrame frame = new Quiz3B();
       frame.setSize(300, 300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}