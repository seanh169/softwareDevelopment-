package HomeWorkThree;


/**
 * 
 * 
 * File Name : Homework3.java
 * Author : Sean Hamilton
 * Date: 11/08/2019
 * Purpose of program: Homework 3 CMSC 412 UMUC. Solution. 
 * 
 * Requirements: Write a program (in C, or Java, or C++, or C#) that creates three new threads (besides the already existing main thread) 
 * and synchronizes them in such a way that each thread displays it's thread id in turn for 5 iterations. 
 * The output of the program should look like this:
 * 
 *
 */



public class Homework3 {
	
	   
	   //private variables	
	   private static int iteration = 1;
	   private static int threadId = 1;
	   private static final int threadCount = 3;
	   private static final int iterationAmount = 5;
	   private static final int endLoop = 6;
	   
	   
	   //default constructor 
	   public Homework3 () {}
	   
	   //method that performs thread synchronizations per homework requirements
	   public void completeHomework() throws InterruptedException {
		   
		 //Initialize thread array
		   Thread[] threads = new Thread[threadCount];
		   
		   for(int i = 0; i < threads.length; i++) {
			   
			   int currentThreatId = i+1;
			   
			   threads[i] = new Thread(new Runnable() {

                   @Override

                   public void run() {

                	   	   boolean stop = true;
                        while (stop) {

                             synchronized(this) {

                                  if (threadId == currentThreatId && iteration <= iterationAmount) {

                                       System.out.println("Thread " + threadId + " - iteration no. " + iteration);

                                       threadId++;

                                       if (currentThreatId == threads.length) {
                                            iteration++;
                                            threadId = 1;
                                       }
                                  }
                                  
                                  //Return false and stop loop at 6.
                                  if (iteration == endLoop) {
                                	  stop = false;
                                  }
                             }
                        }
                   }
	   
			   });
	             threads[i].start();					   
		   }
		   for(int i = 0; i < threads.length; i++) {
	             threads[i].join();
	        }
	   }
	  
	   //Main method.
	   public static void main(String[] args) throws InterruptedException {
		   Homework3 t1 = new Homework3();
		   t1.completeHomework();
		   
	   }
	   
	
}
