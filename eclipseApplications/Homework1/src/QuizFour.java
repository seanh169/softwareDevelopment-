import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class QuizFour {
	
//	ArrayList<Number> listO = new ArrayList<Integer>();
	


	public static void main(String[] args) {
		 QuizFour test = new QuizFour();
//		Comparable date = new Date();
		 ArrayList<String> list1 = new ArrayList();
		 list1.add("red");
		 list1.add("red");
		 list1.add("red");
		 list1.add("red");
		 String element = "red";
		 for (int i = list1.size() - 1; i >= 0; i--)
			   if (list1.get(i).equals(element))
			       list1.remove(element);
			
			System.out.println(list1);
//			System.out.println(list2);
		Collections.sort(list1);
//		Arrays.sort(list1);
		 
	}
}
