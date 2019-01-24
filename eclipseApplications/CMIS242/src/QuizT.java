
public class QuizT {
	
	private int day = 5;
	
	public QuizT() {}
	
	public int returnFive() {
		return day;
	}
	public static void main(String[] args) {
		QuizT x= new QuizT();
		System.out.println(x.day);
	}
}