
public class HouseT {
	//Counter variable to keep track of House Instantiations
		public int numberOfHouses = 0;
		
		// Constructor, increases counter on every call. 
		public HouseT() {
			
			this.numberOfHouses++;
		}
		
		//Simple method that returns a string displaying the counter. 
		public String numberOfHousesInstantiated() {
			
			return "The number of house objects instantiated from this class: " + numberOfHouses;
		}
		
		//Main Method
		public static void main(String[] args) {
			
			HouseT testHouseOne = new HouseT();
			HouseT testHouseTwo = new HouseT();
			System.out.println(testHouseTwo.numberOfHousesInstantiated());
			
		}

}
