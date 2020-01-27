package HomeWorkThree.ect;

class B extends Thread{

    Notification notifyAll;

    B(Notification notifyAllExample){
        this.notifyAll = notifyAllExample;
    }

    @Override
    public void run() {

        try{
            synchronized (notifyAll) {
               int i;
                for (i = 0; i < 5; i++) {

                    while(notifyAll.status!=2){
                        notifyAll.wait();
                    }
                    System.out.println("Thread 2 - iteration no. "+(i+1));
                    notifyAll.status = 3;
                    notifyAll.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 2 :"+e.getMessage());
        }

    }
}
