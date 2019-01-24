
public class House {
	
	//Counter variable to keep track of House Instantiations
	public static int numberOfHouses = 0;
	
	// Constructor, increases counter on every call. 
	public House() {
		
		this.numberOfHouses++;
	}
	
	//Simple method that returns a string displaying the counter. 
	public static String numberOfHousesInstantiated() {
		
		return "The number of house objects instantiated from this class: " + numberOfHouses;
	}
	
	//Main Method
	public static void main(String[] args) {
		
		House testHouseOne = new House();
		House testHouseTwo = new House();
		System.out.println(House.numberOfHousesInstantiated());
		
	}
	

}
