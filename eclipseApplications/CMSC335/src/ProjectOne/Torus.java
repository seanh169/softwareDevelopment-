package ProjectOne;

public class Torus extends ThreeDimensionalShape {
	
	public Torus(double majorRadius, double minorRadius) {
		this.volume = (Math.PI * (Math.pow(minorRadius, 2)) * (2 * Math.PI * majorRadius)  );
	}
	

}
