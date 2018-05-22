
public class TicTacToe {
	
	// FOR STORAGE: 
	// 0 | 1 | 2 
	// 3 | 4 | 5
	// 6 | 7 | 8
	// FOR USER APPEAL
	// 1 | 2 | 3
	// 4 | 5 | 6
	// 7 | 8 | 9
	
	//UI Picture of Game:
	// INIT:
	// | O | - | - 
	// ------------
	// | - | O | - 
	// ------------
	// | X | - | X
	// ------------
	
	protected char[] board;
	protected char userMarker;
	protected char aiMarker;
	protected char winner;
	
	protected char currentMarker;
	
	public TicTacToe(char playerToken, char aiMarker) { 
		this.userMarker = playerToken; 
		this.aiMarker = aiMarker;
		this.winner = '-';
		this.board = setBoard();
		
	}
	public char[] setBoard() { 
		char[] board = new char[9];
		for(int i = 0; i < board.length; i++) {
			board[i] = '-';
		}	
		return board;
	}
	
//	public boolean playTurn(int spot) {
//		boolean isValid = withinRange(spot) && !isSpotTaken(spot);
//		is (isValid) { 
//			board[spot-1];
//		}
	}

