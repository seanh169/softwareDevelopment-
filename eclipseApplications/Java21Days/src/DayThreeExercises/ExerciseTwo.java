package DayThreeExercises;

public class ExerciseTwo {
	int height;
	int weight;
	int depth;
	public ExerciseTwo(int height, int weight, int depth) {
		this.height = height;
		this.depth = depth;
		this.weight = weight;
	}
	public static void main(String[] args) {
		ExerciseTwo n = new ExerciseTwo(3, 2, 1);
	
		System.out.println("Height: " + n.height + " Weight: " + n.weight + " Depth: " + n.depth);
	}
}
