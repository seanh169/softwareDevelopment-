
public class Dog implements WeekFiveDiscussion {

	@Override
	public void beHappy() {
		System.out.println("I BARK WHEN IM HAPPY");
		
	}
	
	public static void main(String[] args) {
		
		Dog test = new Dog();
		test.beHappy();
	}

}
