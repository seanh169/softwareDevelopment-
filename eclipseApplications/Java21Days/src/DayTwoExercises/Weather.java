package DayTwoExercises;

public class Weather {
	public static void main(String[] args) {
		float fah = 86;
		int x, y, z;
		x= 42;
		y = x++;
		z = ++x;
//		System.out.println(fah + " degrees Fahrenheit is....");
		//to convert fahrenheit to celsius
		//behing by subtracting 32
		fah = fah - 32;
		//Divide by 9
		fah =fah/9;
		//Multiple by 5
		fah = fah*5;
//		System.out.println(fah + " degrees Celsius");
		float cel = 33;
//		System.out.println(cel + " degrees Celsius is...");
		//Converting Cel = Far
		//Begin by multiplying by 9.
		cel = cel * 9;
		//Divide by 5
		cel =cel/5;
		//Add 32 to the answer
		cel = cel + 32;
//		System.out.println(cel + " degrees Celsius");
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
}
