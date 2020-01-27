package ProjectOne;

public class Cylinder extends ThreeDimensionalShape {
	
	public Cylinder(double radius, double height) {
		this.volume = Math.PI * (Math.pow(radius, 2)) * height;
	}

}
