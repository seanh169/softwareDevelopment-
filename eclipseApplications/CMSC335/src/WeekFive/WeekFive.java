package WeekFive;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//import WeekFive.SimpleThreads.MessageLoop;

public class WeekFive extends JFrame implements Runnable {
	static final int WIDTH = 600, HEIGHT = 600;
	static DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
	static String time;
	public void run() {
		System.out.println("Hello from a thread!");
	}
	private static class MessageLoop implements Runnable {
		public static String startTime;
		@Override
		public void run() {
			
			for (int i = 0;
                    i < 50;
                    i++) {
                   // Pause for 4 seconds
                   try {
					Thread.sleep(1000);
					System.out.println(formatter.format(System.currentTimeMillis()));
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                   // Print a message
                   
               }
			
			
		}
		
		
	}
	
	public WeekFive() {
		super("Timer");
		setFrame(WIDTH, HEIGHT);
		JPanel panel = new JPanel();
		JLabel timerShown = new JLabel("Time Here");
		JButton startTimer = new JButton("Start");
		JButton pauseTimer = new JButton("Pause");
		Thread x = new Thread(new Runnable() {
			public void run() {
				for (int i = 0;
	                    i < 50;
	                    i++) {
	                   // Pause for 4 seconds
//	                   try {
//						Thread.sleep(1000);
	                	   Timer timer = new Timer(100, null);
	                	   timer.start();
	                	   
						timerShown.setText(formatter.format(System.currentTimeMillis()));
						
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
	                   // Print a message
	                   
	               }
			}
		});
		startTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				 
				x.start();
			}
		});
		pauseTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		
		});
		panel.setLayout(new GridLayout(6,1));
		panel.add(timerShown);
		panel.add(startTimer);
		panel.add(pauseTimer);
		
		add(panel);
		
        
		
		
	}
	public void display() {
	      setVisible(true);
	}
	
	private void setFrame(int width, int height) {
	      setSize(width, height);     
	      setLocationRelativeTo(null);  		
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main(String[] args) throws InterruptedException {
//		(new Thread(new WeekFive())).start();
//		JFrame jfram = new JFrame("Project 1 - Java 2D Graphics"); 
//		 long start = System.currentTimeMillis();
//	        Thread.sleep(2000);
//	        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
		
		WeekFive w5 = new WeekFive();
		w5.display();
	}

}
