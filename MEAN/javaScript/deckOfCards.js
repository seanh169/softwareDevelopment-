class Card{
	constructor(suit, value, nvalue){
		this.suit = suit;
		this.svalue = value; 
		this.nvalue = nvalue;
	}
	showCard(){
		console.log(`This Card's Suit: ${this.suit}, String Value: ${this.svalue}, Number Value: ${this.nvalue}`);
	}

}
class Deck {
	// var cards = [];
	constructor() {
		this.names = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K'];
		this.suits = ['Hearts','Diamonds','Spades','Clubs'];
		this.cards = [];
		for( var s = 0; s < this.suits.length; s++ ) {
        for( var n = 0; n < this.names.length; n++ ) {
            this.cards.push( new Card( n+1, this.names[n], this.suits[s] ) );
        }
    }
    // return this.cards;
    console.log(this.cards);
	}
	shuffle() {
  		var m = this.cards.length, t, i;

  	// While there remain elements to shuffle…
  		while (m) {

    // Pick a remaining element…
    	i = Math.floor(Math.random() * m--);

    // And swap it with the current element.
    	t = this.cards[m];
    	this.cards[m] = this.cards[i];
    	this.cards[i] = t;
  		}

  	return this.cards;
	}
	reset(){
		this.cards =[];
		for( var s = 0; s < this.suits.length; s++ ) {
        for( var n = 0; n < this.names.length; n++ ) {
            this.cards.push( new Card( n+1, this.names[n], this.suits[s] ) );
        }
    }
	}
	dealRandomCard(){
		let i = Math.floor(Math.random()*(52-1)+1);
		return this.cards.splice(i, 1);
	}
}
class Player {
	constructor(playerName){
		this.playerName = playerName;
		
		this.newDeck = new Deck();
		this.newDeck.shuffle();
		this.playerHand = this.newDeck.cards.slice(0,5);
		

	}
	takeCard(){
		console.log(`${this.playerName} is drawing a new card!`);
		let i = Math.floor(Math.random()*(25-1)+1);
		// var newestDeck = new Deck();
		let newCard = this.newDeck.dealRandomCard()[0];
		this.playerHand.push(newCard);
		console.log(`${this.playerName} has recieved a ${newCard.svalue} of ${newCard.nvalue}`);
		return this.playerHand;
	}
	discardCard(){
		this.playerHand.pop();
		return this.playerHand;
	}





}












