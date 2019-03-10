
public class Bird implements WeekFiveDiscussion {

	@Override
	public void beHappy() {
		System.out.println("I CHIRP WHEN IM HAPPY");
	}
	public static void main(String[] args) {
		Bird testBird = new Bird();
		testBird.beHappy();
	}

}
