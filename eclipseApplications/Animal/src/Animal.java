
public abstract class Animal {
	private int age;
	
	
	public Animal(int age) {
		this.age = age;
		System.out.println("An animal has been created!");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		
		this.age = age;
	}
	public void sleep() {
		System.out.println("An Animal is sleeping");
	}
	
	public abstract void eat(); 
	
	
	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat(12);
//		d.ruff();
//		c.meow();
		d.eat();
		c.eat();
		d.sleep();
		c.sleep();
//		d.run();
//		c.prance();
//		d.growOlder();
//		d.growOlder();
//		System.out.println(d.getAge());
//		System.out.println(c.getAge());
	}
}
