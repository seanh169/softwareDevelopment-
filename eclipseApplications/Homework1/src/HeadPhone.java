import java.awt.Color;
import java.lang.reflect.Field;

public class HeadPhone {
	
//	Three constants named LOW, MEDIUM and HIGH with values of 1, 2 and 3 to denote the
//	headphone volume
	
	private static final int LOW = 1;
	private static final int MEDIUM = 2;
	private static final int HIGH = 3;

	
//	A private int data field named volume that specifies the volume of the headphone. The
//	default volume is MEDIUM.
	
	private int volume = HeadPhone.MEDIUM;
	
//	A private boolean data field named pluggedIn that specifies if the headphone is plugged
//	in. The default value is false.
	
	private boolean pluggedIn;
	
//	A private String data field named manufacturer that specifies the name of the
//	manufacturer of the headphones.
	
	private String manufacturer; 
	
//	A private Color data field named headPhoneColor that specifies the color of the
//	headphones.
	
	private Color headPhoneColor; 
	
//	A private String data field named headPhoneModel that specifies the Model of the
//	headphones.
	
	private String headPhoneModel;
	
//	getter and setter methods for all data fields

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isPluggedIn() {
		return pluggedIn;
	}

	public void setPluggedIn(boolean pluggedIn) {
		this.pluggedIn = pluggedIn;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Color getHeadPhoneColor() {
		return headPhoneColor;
	}

	public void setHeadPhoneColor(Color headPhoneColor) {
		this.headPhoneColor = headPhoneColor;
	}

	public String getHeadPhoneModel() {
		return headPhoneModel;
	}

	public void setHeadPhoneModel(String headPhoneModel) {
		this.headPhoneModel = headPhoneModel;
	}

	public static int getLow() {
		return LOW;
	}

	public static int getMedium() {
		return MEDIUM;
	}

	public static int getHigh() {
		return HIGH;
	}
	
//	A no argument constructor that creates a default headphone

	public HeadPhone() {}
	
	//Method to display text representation of rgb Color 
		public static String getColorName(Color c) {
		    for (Field f : Color.class.getFields()) {
		        try {
		            if (f.getType() == Color.class && f.get(null).equals(c)) {
		                return f.getName();
		            }
		        } catch (java.lang.IllegalAccessException e) {
		            // it should never get to here
		        } 
		    }
		    return "unknown";
		}
	
	
//	A method named toString() that returns a string describing the current field values of
//	the headphones.
	public String headPhoneToString(){
		
		return "The current volume: " + volume + "\n" +
				"Plugged in? " + pluggedIn + "\n" +
				"Manufacturer: " + manufacturer + "\n" +
				"Headphone Color: " + HeadPhone.getColorName(headPhoneColor) + "\n" +
				"Headphone Model: " + headPhoneModel + "\n";
		
	}
	
//	A method named changeVolume(value) that changes the volume of the headphone to
//	the value passed into the method
	
	public void changeVolume(int value) {
		
		this.setVolume(value);
		
	}
	
	
}
