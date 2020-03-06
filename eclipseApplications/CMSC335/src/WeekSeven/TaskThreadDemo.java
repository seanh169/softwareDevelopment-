package WeekSeven;

 public class TaskThreadDemo {
	 
	 
	 public static void main (String args []) {
		 String [] sa = {"a", "X", "+", "."};
		 for (String s: sa) {
		 Runnable ps = new PrintChar (s, 200);
		 Thread ts = new Thread (ps, s);
		 ts.start ();
		 } // end for each character
	 } // end main
 } // end class TaskThreadDemo

 class PrintChar implements Runnable {
 String ch;
 int times;


 public PrintChar (String c, int n) {
 ch = c;
 times = n;
 } // end constructor

 public void run () {
	 String maxtimes = "";
 for (int i = 0; i < times; i++) {
 System.out.print (ch);
 System.out.println(Thread.currentThread().getName());
 System.out.println(Thread.currentThread().getId());
// Thread.yield();
// maxtimes += ch;
 } // end for loop
// System.out.println(maxtimes.length());
// System.out.println("------------- \n");
 } // end method run
 } // end class PrintChar