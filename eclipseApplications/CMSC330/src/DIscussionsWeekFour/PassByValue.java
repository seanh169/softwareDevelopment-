package DIscussionsWeekFour;

public class PassByValue {

	
	public PassByValue() {
		int param = 4;
		change(param);
		System.out.println(param);
		
		Parti paramObject = new Parti();
		changes(paramObject);
		System.out.println(paramObject.x + ", " + paramObject.y);
	}
	
	
	void change(int changeParameter){
		changeParameter = changeParameter*2;
	}
	
	void changes(Parti inputParti) {
		inputParti.x = 2;
		inputParti.y = 100;
	}
	
	public class Parti {
		int x;
		int y;
		Parti(){
			this.x = 5;
			this.y = 7;
		}
	}
	
	public static void main(String[] args) {
		PassByValue e1 = new PassByValue();
		
	}
}
