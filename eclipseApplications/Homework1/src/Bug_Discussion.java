import java.io.*;

 

public class Bug_Discussion {

 

   public static void main(String[] args) throws IOException{

 

       int month;

 

       BufferedReader stdin = new BufferedReader (

               new InputStreamReader(System.in));

 

       System.out.print("Please enter the month you were born in (i.e. 1,2,3,4,etc...): ");

       month = Integer.parseInt(stdin.readLine());

 

       if (month == 1) {

           System.out.println("Hey, did you know you were born in January!?");

       }

       else if (month==2) {

           System.out.println("Hey, did you know you were born in February!?");

       }

       else if (month==3) {

           System.out.println("Hey, did you know you were born in March!?");

       }

       else if (month==4) {

           System.out.println("Hey, did you know you were born in April!?");

       }

       else if (month==5) {

           System.out.println("Hey, did you know you were born in May!?");

       }

       else if (month==6) {

           System.out.println("Hey, did you know you were born in June!?");

       }

       else if (month==7) {

           System.out.println("Hey, did you know you were born in July!?");

       }

       else if (month==8) {

           System.out.println("Hey, did you know you were born in August!?");

       }

       else if (month==9) {

           System.out.println("Hey, did you know you were born in September!?");

       }

       else if (month==10) {

           System.out.println("Hey, did you know you were born in October!?");

       }

       else if (month==11) {

           System.out.println("Hey, did you know you were born in November!?");

       }

       else if (month==12) {

           System.out.println("Hey, did you know you were born in December!?");

       }

       else {

           System.out.println("Hey, that's not a valid month!");

       }

   }

}