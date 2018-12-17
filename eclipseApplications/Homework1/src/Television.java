
public class Television {
	
	public boolean isPoweredOn;
	
	public Television() {}
	
	public boolean pressPowerButton() {
		return this.isPoweredOn = !this.isPoweredOn;
	}
	
	public static void main(String[] args) {
		
		Television simpleTV = new Television();
		System.out.println(simpleTV.isPoweredOn);
		simpleTV.pressPowerButton();
		System.out.println(simpleTV.isPoweredOn);
		
	}
	
}
