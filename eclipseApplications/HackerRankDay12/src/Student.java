
public class Student extends Person {
	private int[] testScores;
	
	public Student(String firstName, String lastName, int id, int[] testScores) {
		super(firstName, lastName, id);
		this.testScores = testScores;
	}
	
	public int calculate() {
		int sum = 0;
		int[] tesstScores = new int[2];
		tesstScores[0] = 5;
		tesstScores[1] = 10;
		for(int i = 0; i < tesstScores.length; i++) {
			sum = sum + tesstScores[i];
//			System.out.println(sum);
		}
		System.out.println(sum);
		return sum;
	}
	public static void main(String[] args) {
		int[] tesstScores = new int[2];
		tesstScores[0] = 5;
		tesstScores[1] = 10;
		Student s = new Student("Sean", "Hamilton", 3, tesstScores);
		s.calculate();
	}
}
