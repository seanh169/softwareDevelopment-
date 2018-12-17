

public class Vacuum {
	private boolean isOn;
	private boolean plugged;
	
	public Vacuum () {
		isOn = false;
		plugged = false;
	}
	
	public Vacuum (boolean isOn, boolean plugged) {
		this.isOn = isOn;
		this.plugged = plugged;
	}
	
	public String pressPower() {
		
		this.isOn = !this.isOn;
		String powerView;
		if(this.isOn) {
			powerView = "This vacuum is now on";
		}else {
			powerView = "This vacuum is now off";
		}

		return powerView;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public boolean isPlugged() {
		return plugged;
	}

	public void setPlugged(boolean plugged) {
		this.plugged = plugged;
	}

	public String toString () {
		String on = "";
		if (this.isOn == false) {
			on = "off";
		}
		if (this.isOn == true) {
			on = "on";
		}
		
		String plugged = "";
		if (this.plugged == false) {
			plugged = "and not plugged in.";
		}
		if (this.plugged == true) {
			plugged = "and plugged in.";
		}
		
		if (this.plugged == false && this.isOn == true) {
			plugged = "but I wonder why it isn't working...";
		}
		String infoString = "The vacuum is " + on + " " + plugged;
		return infoString;
	}
	public static void main(String[] args) {
		Vacuum z = new Vacuum();
		System.out.println(z.pressPower());
		System.out.println(z.pressPower());
		System.out.println(z.toString());
	}
}