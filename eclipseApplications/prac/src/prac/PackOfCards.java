package prac;

public class PackOfCards {
	
	
	public class Card {
		  int[] deck = new int[52];
		  String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		  String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

		  Card() {
		    for (int i = 0; i < deck.length; i++) {
		      deck[i] = i;
		    }
		 }
	}
	
	private Card cardSet[];
	
	
	public PackOfCards() {
		this.cardSet = new Card[52];
		for(int i=0; i < )
	}

}
