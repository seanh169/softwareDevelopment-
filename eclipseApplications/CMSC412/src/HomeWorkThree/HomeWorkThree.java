package HomeWorkThree;






//Define class SynchronizeThreads.

public class HomeWorkThree {

   //Declare private static member variables.

   private static int thread_num = 1;

   private static int iter_num = 1;

   //Start the main() method and throw interrupt exception.

   public static void main(String[] args) throws InterruptedException {

        //Create an array of threads.

        Thread[] pthreads = new Thread[3];

       

        //Start the for loop till the size of the array.

        for(int thread_index = 0; thread_index < pthreads.length; thread_index++) {

             //Assign the loop index value incremented by 1 to thread id variable.

             int threadId = thread_index+1;
//        	int threadId = thread_index++;
             
             //Create a thread using new and runnable interface.

             pthreads[thread_index] = new Thread(new Runnable() {

                   //Override the run() method of runnable interface.

                   @Override

                   public void run() {

                        //Start a while loop.

                        while (true) {

                             //Synchronized the current thread.

                             synchronized(this) {

                                  //If the thread number is equal to current thread id and current iteration index is less than equal to 5.

                                  if (thread_num == threadId && iter_num <= 5) {

                                       //Display the thread id with current iteration index.

                                       System.out.println("Thread " + thread_num + " - iteration no. " + iter_num);
                                       
                                       System.out.println("");
                                       //Increment the thread index.

                                       thread_num++;

                                       //If the current thread id is equal to size of array pthreads.

                                       if (threadId == pthreads.length) {

                                            //Increment the iteration index.
                                            iter_num++;
                                            //Make the thread number 1 again.
                                            thread_num = 1;
                                       }
                                  }
                                  //If the current iteration number is equal to 6, then break the loop.

                                  if (iter_num == 6) {
                                	  break;
                                  }
                             }
                        }
                   }
             });

            

             //Start all the threads.

             pthreads[thread_index].start();

        }

       

        //Join all the threads.

        for(int thread_index = 0; thread_index < pthreads.length; thread_index++) {

             pthreads[thread_index].join();

        }

   }

}
