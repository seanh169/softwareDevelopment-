package ProjectOne;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProjectOne {
	
	
	
	public static void main(String[] args) {
		
		//Scanner for accepting user input
		Scanner in = new Scanner(System.in);
		
		//Input line from user 
		String inputLine;
		
		//regex for input validation
		String regex = "[0-9]+";
		//Main loop with all necessary options per requirements.
		while (true) { 
			
			System.out.println("*********Welcome to the Java OO Shapes Program **********");
			System.out.println("Select from the menu below: ");
			System.out.println("1. Construct a Circle");
			System.out.println("2. Construct a Rectangle");
			System.out.println("3. Construct a Square");
			System.out.println("4. Construct a Triangle");
			System.out.println("5. Construct a Sphere");
			System.out.println("6. Construct a Cube");
			System.out.println("7. Construct a Cone");
			System.out.println("8. Construct a Cylinder");
			System.out.println("9. Construct a Torus");
			System.out.println("10. Exit the program");
			
			
			inputLine = in.nextLine();
			if( (!inputLine.matches(regex))) {
				System.out.println("Invalid input. Please Try Again.");
				 continue;
			}else {
				
				switch (inputLine) {
					case "1":
						System.out.println("You have selected a Circle.");
						System.out.println("Radius? (Number) ");
						if( !in.hasNextDouble()) {
							break;
						}
						double radius  = in.nextDouble();
						Circle outputCircle = new Circle(radius);
						System.out.println("Area of circle: " + outputCircle.area);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String contin;
						contin = in.nextLine();
						if((contin.equals(new String("Y"))) || (contin.equals(new String("N"))) ) {
							if(contin.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
							continue;
						}
						break;
					case "2":
						System.out.println("You have selected a Rectangle.");
						System.out.println("What is the length? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double length = in.nextDouble();
						System.out.println("What is the width? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double width = in.nextDouble();
						Rectangle outputRectangle = new Rectangle(length, width);
						System.out.println("Area of Rectangle: " + outputRectangle.area);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continRec;
						continRec = in.nextLine();
						if((continRec.equals(new String("Y"))) || (continRec.equals(new String("N"))) ) {
							if(continRec.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "3":
						System.out.println("You have selected a Square.");
						System.out.println("What is the length of a side? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double lengthOfSide = in.nextDouble();
						Square squareOutput = new Square(lengthOfSide);
						System.out.println("Area of Square: " + squareOutput.area);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continSqu;
						continSqu = in.nextLine();
						if((continSqu.equals(new String("Y"))) || (continSqu.equals(new String("N"))) ) {
							if(continSqu.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "4":
						System.out.println("You have selected a Triangle.");
						System.out.println("What is the base? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double base = in.nextDouble();
						System.out.println("What is the height? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double height = in.nextDouble();
						Triangle outputTriangle = new Triangle(base, height);
						System.out.println("Area of Triangle: " + outputTriangle.area);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continTri;
						continTri = in.nextLine();
						if((continTri.equals(new String("Y"))) || (continTri.equals(new String("N"))) ) {
							if(continTri.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "5":
						System.out.println("You have selected a Sphere.");
						System.out.println("What is the radius? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double radiusSphere = in.nextDouble();
						Sphere outputSphere = new Sphere(radiusSphere);
						System.out.println("Volume of Sphere: " + outputSphere.volume);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continSph;
						continSph = in.nextLine();
						if((continSph.equals(new String("Y"))) || (continSph.equals(new String("N"))) ) {
							if(continSph.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "6":
						System.out.println("You have selected a Cube.");
						System.out.println("What is the length of an edge? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double lengthOfEdge = in.nextDouble();
						Cube outputCube = new Cube(lengthOfEdge);
						System.out.println(("Volume of Cube: " + outputCube.volume));
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continCub;
						continCub = in.nextLine();
						if((continCub.equals(new String("Y"))) || (continCub.equals(new String("N"))) ) {
							if(continCub.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "7":
						System.out.println("You have selected a Cone.");
						System.out.println("What is the Radius? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double coneRadius = in.nextDouble();
						System.out.println("What is the Height? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double coneHeight = in.nextDouble();
						Cone outputCone = new Cone(coneRadius, coneHeight);
						System.out.println("Volume of Cone: " + outputCone.volume);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continCon;
						continCon = in.nextLine();
						if((continCon.equals(new String("Y"))) || (continCon.equals(new String("N"))) ) {
							if(continCon.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "8":
						System.out.println("You have selected a Cylinder.");
						System.out.println("What is the Radius? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double radiusCylinder = in.nextDouble();
						System.out.println("What is the Height? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double radiusHeight = in.nextDouble();
						Cylinder outputCylinder = new Cylinder(radiusCylinder, radiusHeight);
						System.out.println("Volume of Cylinder: " + outputCylinder.volume);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continCyl;
						continCyl = in.nextLine();
						if((continCyl.equals(new String("Y"))) || (continCyl.equals(new String("N"))) ) {
							if(continCyl.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "9": 
						System.out.println("You have selected a Torus.");
						System.out.println("What is the Major Radius? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double majorRadius = in.nextDouble();
						System.out.println("What is the Minor Radius? ");
						if( !in.hasNextDouble()) {
							break;
						}
						double minorRadius = in.nextDouble();
						Torus outputTorus = new Torus(majorRadius, minorRadius);
						System.out.println("Volume of Torus: " + outputTorus.volume);
						in.nextLine();
						System.out.println("Would you like to continue? (Y or N)");
						String continTor;
						continTor = in.nextLine();
						if((continTor.equals(new String("Y"))) || (continTor.equals(new String("N"))) ) {
							if(continTor.equals(new String("N"))) {
								System.out.println("Exiting..");
								System.exit(0);
								break;
							}else {
								System.out.println("Choose again");
							}		
						}else {
							System.out.println("Sorry I do not understand. Enter Y or N");
							in.nextLine();	
						}
						break;
					case "10":
						LocalDateTime ldt = LocalDateTime.now(); 
						DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
						DateTimeFormatter day = DateTimeFormatter.ofPattern("dd");
						DateTimeFormatter timeFormat =  DateTimeFormatter.ofPattern("hh a");
						String formattedMonth= ldt.format(month);
						String formattedDay= ldt.format(day);
						String formattedTime= ldt.format(timeFormat);
						System.out.println("Thanks for using the program. Today is " + formattedMonth + " " + formattedDay + " at " + formattedTime );
						System.exit(0);		
				}
			}
		}
	}
}