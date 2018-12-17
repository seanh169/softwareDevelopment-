
public class Blender {
	
	public boolean isOn;
	
	public Blender() {

	}
	
	public boolean pressPowerButton() {
		return this.isOn = !this.isOn;
	}
	
	public static void main(String[] args) {
		
		Blender basicBlender = new Blender();
		System.out.println(basicBlender.isOn);
		basicBlender.pressPowerButton();
		System.out.println(basicBlender.isOn);
	}

}
