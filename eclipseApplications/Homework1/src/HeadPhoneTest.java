import java.awt.Color;

public class HeadPhoneTest {
	
	public static void main(String[] args) {
		
		HeadPhone headPhoneTestOne = new HeadPhone();
		System.out.println("*******TEST 1*******");
		headPhoneTestOne.setVolume(1);
		headPhoneTestOne.setPluggedIn(true);
		headPhoneTestOne.setManufacturer("Bose");
		headPhoneTestOne.setHeadPhoneColor(new Color(255,0,0));
		headPhoneTestOne.setHeadPhoneModel("Quiet Comfort");
		System.out.println(headPhoneTestOne.headPhoneToString());
		HeadPhone headPhoneTestTwo = new HeadPhone();
		System.out.println("*******TEST 2*******");
		headPhoneTestTwo.setVolume(2);
		headPhoneTestTwo.setPluggedIn(false);
		headPhoneTestTwo.setManufacturer("Sony");
		headPhoneTestTwo.setHeadPhoneColor(new Color(0,0,0));
		headPhoneTestTwo.setHeadPhoneModel("MX-765");
		System.out.println(headPhoneTestTwo.headPhoneToString());
		HeadPhone headPhoneTestThree = new HeadPhone();
		System.out.println("*******TEST 3*******");
		headPhoneTestThree.setVolume(3);
		headPhoneTestThree.setPluggedIn(true);
		headPhoneTestThree.setManufacturer("LG");
		headPhoneTestThree.setHeadPhoneColor(new Color(0,0,255));
		headPhoneTestThree.setHeadPhoneModel("EverSmart");
		System.out.println(headPhoneTestThree.headPhoneToString());
		
		
		
		
	}
	
	
	
}
