package HomeWorkThree.ect;

class C extends Thread{

    Notification notifyAll;

    C(Notification notifyAllExample){
        this.notifyAll = notifyAllExample;
    }

    @Override
    public void run() {

        try{
            synchronized (notifyAll) {
                int i;
                for (i = 0; i < 5; i++) {

                    while(notifyAll.status!=3){
                        notifyAll.wait();
                    }

                    System.out.println("Thread 3 - iteration no. "+(i+1));
                    notifyAll.status = 1;
                    notifyAll.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 3 :"+e.getMessage());
        }
    }
}
