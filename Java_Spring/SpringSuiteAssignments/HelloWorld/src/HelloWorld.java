import java.util.ArrayList;

public class HelloWorld {

	public static void main(String[] args) {
//		int myArray[] = new int[10];
//		for(int i = 0; i < myArray.length; i++) {
//			System.out.println(i);
//		}
		ArrayList<ArrayList<Integer>> myFrogs = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list2.add(6);
		myFrogs.add(list);
		myFrogs.add(list2);
		
//		myFrogs.add(6);
//		myFrogs.set(1, 7);
		
		System.out.println(myFrogs);
		
		ArrayList<Integer> subList = myFrogs.get(0);
		subList.add(7);
		myFrogs.set(0,subList);
		
		System.out.println(myFrogs);
		

	}

	
}
