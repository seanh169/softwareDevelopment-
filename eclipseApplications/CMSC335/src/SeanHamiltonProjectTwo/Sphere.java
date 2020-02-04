package SeanHamiltonProjectTwo;

public class Sphere extends ThreeDimensionalShape {
	
	
	public Sphere(double radius) {
		double radCubed = (Math.pow(radius, 3));
		double x = ((double) 4) / 3;
		this.volume = (radCubed * Math.PI * x);
	}

}
