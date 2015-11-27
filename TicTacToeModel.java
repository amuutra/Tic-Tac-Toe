package tictac;

public class TicTacToeModel {

	private int[] gameGrid;
	
	private boolean X_TURN = false;
	private boolean O_TURN = false;
	
	private final int X_PLAYER = 1;
	private final int O_PLAYER = 2;
	
	private int winningPlayer;
	private boolean gameEnded = false;
	
	
	public TicTacToeModel() {	
		gameGrid = new int[9];	
		X_TURN = true;
	}
		
	private void nextTurn() {
	
		if(X_TURN) {
			X_TURN = false;
			O_TURN = true;
		} else if (O_TURN) {
			O_TURN = false;
			X_TURN = true;
		}
		
	}
	
	private boolean playerWon() {
				
		if( (gameGrid[0] == X_PLAYER && gameGrid[1] == X_PLAYER &&  gameGrid[2] == X_PLAYER) ||
			(gameGrid[3] == X_PLAYER && gameGrid[4] == X_PLAYER &&  gameGrid[5] == X_PLAYER) ||
		    (gameGrid[6] == X_PLAYER && gameGrid[7] == X_PLAYER &&  gameGrid[8] == X_PLAYER) ||	
	    	(gameGrid[0] == X_PLAYER && gameGrid[3] == X_PLAYER &&  gameGrid[6] == X_PLAYER) ||
			(gameGrid[1] == X_PLAYER && gameGrid[4] == X_PLAYER &&  gameGrid[7] == X_PLAYER) ||
			(gameGrid[2] == X_PLAYER && gameGrid[5] == X_PLAYER &&  gameGrid[8] == X_PLAYER) || 
			(gameGrid[0] == X_PLAYER && gameGrid[4] == X_PLAYER &&  gameGrid[8] == X_PLAYER) || 
			(gameGrid[2] == X_PLAYER && gameGrid[4] == X_PLAYER &&  gameGrid[6] == X_PLAYER)) 
		{
			gameEnded = true;
			winningPlayer = X_PLAYER;
			return true;
			
		} else if ((gameGrid[0] == O_PLAYER && gameGrid[1] == O_PLAYER &&  gameGrid[2] == O_PLAYER) ||
				(gameGrid[3] == O_PLAYER && gameGrid[4] == O_PLAYER &&  gameGrid[5] == O_PLAYER) ||
			    (gameGrid[6] == O_PLAYER && gameGrid[7] == O_PLAYER &&  gameGrid[8] == O_PLAYER) ||	
		    	(gameGrid[0] == O_PLAYER && gameGrid[3] == O_PLAYER &&  gameGrid[6] == O_PLAYER) ||
				(gameGrid[1] == O_PLAYER && gameGrid[4] == O_PLAYER &&  gameGrid[7] == O_PLAYER) ||
				(gameGrid[2] == O_PLAYER && gameGrid[5] == O_PLAYER &&  gameGrid[8] == O_PLAYER) || 
				(gameGrid[0] == O_PLAYER && gameGrid[4] == O_PLAYER &&  gameGrid[8] == O_PLAYER) || 
				(gameGrid[2] == O_PLAYER && gameGrid[4] == O_PLAYER &&  gameGrid[6] == O_PLAYER)) {
				
			gameEnded = true;
			winningPlayer = O_PLAYER;
			return true;
			
		} else {
			return false;
		}
		

		
	}
	
	public void placeShape(int square) {
		
		if(!gameEnded) {
			
			gameGrid[square - 1] = getCurrentPlayer();	
			
			if(playerWon()) {
				gameEnded = true;
			} else {
				nextTurn();		
			}
			
		}	
				
	}
	
	public int getSquare(int square) {
		return gameGrid[square - 1];
	}
	
	private int getCurrentPlayer() {
		
		if(X_TURN) {
			return X_PLAYER;
		} else {
			return O_PLAYER;
		}
		
	}
			
}