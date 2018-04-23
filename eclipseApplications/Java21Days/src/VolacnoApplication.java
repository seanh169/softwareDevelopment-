
public class VolacnoApplication {
	public static void main(String[] args) {
		VolcanoRobot dante = new VolcanoRobot();
		dante.status = "exploring";
		dante.speed = 2;
		dante.temperature = 510;
		VolcanoRobot virgil = new VolcanoRobot();
		virgil.speed = 5;
		virgil.status = "BUSY";
		virgil.temperature = 250;
		
		
//		dante.showAttributes();
//		System.out.println("Increasing speed to 3.");
//		dante.speed = 3;
//		dante.showAttributes();
//		System.out.println("Changing temperature to 670");
//		dante.temperature = 670;
//		dante.showAttributes();
//		System.out.println("Checking the temperature");
//		dante.checkTemperature();
//		dante.showAttributes();
		
		virgil.showAttributes();
//		System.out.println("Increasing speed to 3.");
//		virgil.speed = 3;
//		virgil.showAttributes();
//		System.out.println("Changing temperature to 670");
//		virgil.temperature = 670;
//		virgil.showAttributes();
//		System.out.println("Checking the temperature");
//		virgil.checkTemperature();
//		virgil.showAttributes();
				
	}
}
