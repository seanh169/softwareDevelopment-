package HomeWorkThree.ect;

class A extends Thread{
    Notification notifyAll;

    A(Notification notifyAllExample){
        this.notifyAll = notifyAllExample;
    }

    @Override
    public void run() {

        try{
            synchronized (notifyAll) {

                for (int i = 0; i < 5; i++) {

                    while(notifyAll.status!=1){
                        notifyAll.wait();
                    }
                    System.out.println("Thread 1 - iteration no. "+(i+1));
                    notifyAll.status = 2;
                    notifyAll.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 1 :"+e.getMessage());
        }

    }

}
