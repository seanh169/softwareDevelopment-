package WeekEight;



public class WeekEightDiscussion {
	
	public static void main(String[] args) {
		
		final String name1 = "Sean";
		final String name2 = "John";
		
		Thread threadOne = new Thread() {
			public void run() {
				synchronized(name1) {
					System.out.println("Thread One has Locked named 1");
					try {
						Thread.sleep(100);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					synchronized(name2) {
						System.out.println("Thread One locking name 2");
					}
				}
			}
		};
		
		Thread threadTwo = new Thread() {
			public void run() {
				synchronized(name2) {
					System.out.println("Thread Two locking name 2");
					try {
						Thread.sleep(100);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					synchronized(name1) {
						System.out.println("Thread Two locking name 2");
					}
				}
			}
		};
		threadOne.start();
		threadTwo.start();
		
	}
}
