package HomeWorkThree.ect;

public class Notification {

    int status=1;
    public static void main(String[] args) {

        Notification notifyAllExample = new Notification();

        A a=new A(notifyAllExample);
        B b=new B(notifyAllExample);
        C c=new C(notifyAllExample);

        a.start();
        b.start();
        c.start();
    }
}
