package WeekFive;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WeekFive extends JPanel implements Runnable {
	
	
	public void run() {
		System.out.println("Hello from a thread!");
	}
	
	public WeekFive() {
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
//		(new Thread(new WeekFive())).start();
		JFrame jfram = new JFrame("Project 1 - Java 2D Graphics"); 
		 long start = System.currentTimeMillis();
	        Thread.sleep(2000);
	        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
	}

}
