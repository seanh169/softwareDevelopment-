package GUI;

//SimpleCalculatorApplication.java
import java.awt.*;
public class SimpleCalculatorApplication extends NiceFrame {
	
	
 public SimpleCalculatorApplication() {
    super("Simple Calculator Application", 320, 120);
    add(new SimpleCalculatorPanel()); 
 }
 static public void main(String[] args) {
    SimpleCalculatorApplication scApp = 
       new SimpleCalculatorApplication();
    scApp.display();
 }
}
