
public class WeekTwoDisc {
	
	private int num = 10;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public WeekTwoDisc() {}
	
	public WeekTwoDisc(int num) {
		
		this.num = num;
	}
	
	public String weekTwoDiscToString() {
		
		
		
		return "Private Instance Variable num: " + this.getNum();
				
	}
	
	
	
	public static void main(String[] args) {
		
		WeekTwoDiscSubClass testOneSubClass = new WeekTwoDiscSubClass(25, 50);
		WeekTwoDisc testOneParentClass = new WeekTwoDisc(65);
		
		System.out.println(testOneSubClass.weekTwoDiscToString());
		System.out.println(testOneParentClass.weekTwoDiscToString());
		
		
	}

}
