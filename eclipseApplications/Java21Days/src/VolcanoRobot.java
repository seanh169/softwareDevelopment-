
public class VolcanoRobot {
	String status;
	int speed;
	float temperature;
	
	
	
	
	public void checkTemperature() {
		if (temperature > 660) {
			status = "returning home";
			speed = 5;
			
			}
		}
	
	
	public void showAttributes() {
		System.out.println("Status: " + status);
		System.out.println("Speed: " + speed);
		System.out.println("Temperature: " + temperature);
	}
}
