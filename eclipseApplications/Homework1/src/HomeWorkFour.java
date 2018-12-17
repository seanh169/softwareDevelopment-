import java.util.ArrayList;
import java.util.Scanner;

/**
 * Java program that displays the state bird and flower if user input matches the state. If the user types "non"
 * then the program will stop taking input and display a message containing all of the user states.
 * 
 * @filename HomeWorkFour.java
 * @author Sean Hamilton
 * @date 12/05/2018
 * 
 * 
 */



public class HomeWorkFour {
	
	// 2D Array declaration storing all state bird and flower information
	
	static String[][] stateInfo = new String[][] {
		
        {"Alabama", "Yellowhammer", "Camelia"},
        {"Alaska", "Willow Ptarmigan", "Forget-Me-Not"},
        {"Arizona", "Cactus Wren", "Saguaro Cactus Blossom"},
        {"Arkansas", "Mockingbird", "Apple Blossom"},
        {"California", "California Valley Quail", "Golden Poppy"},
        {"Colorado", "Lark Bunting", "Rocky Mountain Columbine"},
        {"Connecticut", "Robin", "Mountain Laurel"},
        {"Delaware", "Blue Hen Chicken", "Peach Blossom"},
        {"Florida", "Mockingbird", "Orange Blossom"},
        {"Georgia", "Brown Thrasher", "Cherokee Rose"},
        {"Hawaii", "Nene", "Hawaiian Hibiscus"},
        {"Idaho", "Mountain Bluebird", "Syringa, mock orange"},
        {"Illinois", "Cardinal", "Violet"},
        {"Indiana", "Cardinal", "Peony"},
        {"Iowa", "Eastern Goldfinch", "Wild Praire Rose"},
        {"Kansas", "Western Meadowlark", "Sunflower"},
        {"Kentucky", "Cardinal", "Goldenrod"},           
        {"Louisiana", "Eastern Brown Pelican", "Magnolia"},
        {"Maine", "Chickadee", "Pine Cone and Tassel"},
        {"Maryland", "Baltimore Oriole", "Black-Eyed Susan"},
        {"Massachusetts", "Chickadee", "Mayflower"},
        {"Michigan", "Robin", "Apple Blossom"},
        {"Minnesota", "Common Loon", "Pink and White Lady's Slippper"},
        {"Mississippi", "Mockingbird", "Magnolia"},
        {"Missouri", "Bluebird", "Hawthorn"},
        {"Montana", "Western Meadowlark", "Bitterroot"},
        {"Nebraska", "Western Meadowlark", "Goldenrod"},
        {"Nevada", "Mountain Bluebird", "Sagebrush"},
        {"New Hampshire", "Purple Finch", "Purple Lilac"},
        {"New Jersey", "Eastern Goldfinch", "Violet"},
        {"New Mexico", "Roadrunner", "Yucca Flower"},
        {"New York", "Bluebird", "Rose"},
        {"North Carolina", "Cardinal", "Flowering Dogwood"},
        {"North Dakota", "Western Meadowlark", "Wild Praire Rose"},
        {"Ohio", "Cardinal", "Scarlet Carnation"},
        {"Oklahoma","Scissor-tailed Flycatcher","Oklahoma Rose"},            
        {"Oregon", "Western Meadowlark", "Oregon Grape"},
        {"Pennsylvania", "Ruffed Grouse", "Mountain Laurel"},
        {"Rhode Island", "Rhode Island Red", "Violet"},           
        {"South Carolina", "Great Carolina Wren", "Yellow Jessamine"},
        {"South Dakota", "Ring-necked Pheasant", "Pasque Flower"},
        {"Tennessee", "Mockingbird", "Purple Passionflower"},
        {"Texas", "Mockingbird", "Bluebonnet Sp."},
        {"Utah", "Common American Gull", "Sego Lily"},
        {"Vermont", "Hermit Thrush", "Red Clover"},
        {"Virginia","Cardinal"," American Dogwood"},
        {"Washington", "Willow Goldfinch", "Coast Rhododendrum"},
        {"West Virginia", "Cardinal", "Rhododendron"},
        {"Wisconsin", "Robin", "Wood Violet"},
        {"Wyoming", "Western Meadowlark", "Indian Paintbrush"}
    };
	
    // ArrayList of String instantiation. Used to store all user's state input. 
	static ArrayList<String> returnStorage = new ArrayList<String>();
	
	public static void compareToState(String state) {
		
		//Iterate through 2d array and add correlating information if there is match.
		for(int i = 0; i < stateInfo.length; i++) {
			for(int j = 0; j < stateInfo[i].length; j++) {
				if(stateInfo[i][j].replace(" ", "").toLowerCase().equals(state.replace(" ", "").toLowerCase())) {
					
					System.out.println("Bird: " + stateInfo[i][j+1]);
					System.out.println("Flower: " + stateInfo[i][j+2]);
					returnStorage.add("\n" + stateInfo[i][j]);
					returnStorage.add(stateInfo[i][j+1]);
					returnStorage.add(stateInfo[i][j+2]);
					
					
					
				};
			}
		}
		
		
		
	}
	
	public HomeWorkFour() {}
	
	
	
	
	
	
}
