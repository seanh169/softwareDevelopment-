package ProjectOne;

public class Cone extends ThreeDimensionalShape {
	
	
	public Cone(double radius, double height) {
		this.volume = Math.PI * (Math.pow(radius, 2)) * (height / 3);
	}

}
