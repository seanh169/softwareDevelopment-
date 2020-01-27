package WeekOne;

public class MyClassD {
     public static void main (String args []) {
       MyClassC m = new MyClassC (23);
       System.out.println(m.v);
     } // end main
   } // end class MyClassD
 
   class MyClassC {
     int v = 12;

    public MyClassC (int pV) {
      this.v = pV;
    } 
 
  } // end class MyClassC
