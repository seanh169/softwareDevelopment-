import java.awt.Color;

/**
 * 
 * 
 * 
 * @author Sean Hamilton
 * Guitar Test File
 *
 */


public class TestGuitar {
	
	public static void main(String[] args) {
		Guitar guitarOne = new Guitar(3, 28.2, "Hansle", Color.red );
		Guitar guitarTwo = new Guitar(7, 29.6, "Ferrera", Color.blue);
		Guitar guitarThree = new Guitar(5, 27.2, "Tableu", Color.black);
		
		
		System.out.print("----Test One----" + "\n");
		guitarOne.guitarToString();
		System.out.println(guitarOne.getNumStrings());
		System.out.println(guitarOne.getGuitarLength());
		System.out.println(guitarOne.getGuitarManufacturer());
		System.out.println(Guitar.getColorName(guitarOne.getGuitarColor()));
		System.out.println(guitarOne.playGuitar());
		System.out.print("----Test Two----" + "\n");
		guitarTwo.guitarToString();
		System.out.println(guitarTwo.getNumStrings());
		System.out.println(guitarTwo.getGuitarLength());
		System.out.println(guitarTwo.getGuitarManufacturer());
		System.out.println(Guitar.getColorName(guitarTwo.getGuitarColor()));
		System.out.println(guitarTwo.playGuitar());
		System.out.print("----Test Three----" + "\n");
		guitarThree.guitarToString();
		System.out.println(guitarThree.getNumStrings());
		System.out.println(guitarThree.getGuitarLength());
		System.out.println(guitarThree.getGuitarManufacturer());
		System.out.println(Guitar.getColorName(guitarThree.getGuitarColor()));
		System.out.println(guitarThree.playGuitar());
		System.out.println(String.valueOf(guitarThree.getGuitarLength()));
		
		
		
	}

}
