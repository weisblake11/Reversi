
package cs1302.p2;

/** 
 * This abstract class represents a player.
 *
 * @author Frederick Blake Weis
 */
public abstract class Player {

    private int score;
    private char pawn;
    protected boolean moveMade;

    /**
     * Sole constructor for a player object.
     *
     * @param pawn  the symbol for the player's pawn
     */
    public Player(char pawn) {
	this.pawn = pawn;
	score = 0;
    }


    /**
     * Returns the player's score
     *
     * @return player's score
     */
    public int getScore() {
	return score;
    }

    /**
     * Sets the player's score
     *
     * @param score  the value to put into the playrer's score
     */
    public void setScore(int score) {
	this.score = score;
    }

    /**
     * Returns the player's pawn symbol
     *
     * @return player's pawn
     */
    public char getPawn() {
	return pawn;
    }

    /**
     * Determinaes whether a specified spot is an allowable play.
     *
     * @param board   the board to check spot availablility
     * @param row     the row the player would like to place a pawn
     * @param col     the column the player would like to place a pawn
     * @return whether or not the specified move is allowable
     */
    public boolean moveOkay(Board board, int row, int col) {
	if (row < 1 || row > board.getNumberOfRows()) {
	    System.out.println("Row out of range");
	    return false;
	}
	if (col < 1 || col > board.getNumberOfCols()) {
	    System.out.println("Column out of range");
	    return false;
	}
	if (board.getGrid()[row][col] != '_') {
	    System.out.println("Sorry that spot is not a valid play");
	    return false;
	}
	return true;
    }

    /**
     *Takes the user's move and updates the board accordingly
     *
     * @param board   the board to make a move
     * @param other   the other player
     * @param row     the row the player places a pawn
     * @param col     the column the player places a pawn
     */
    public void makeMove(ReversiBoard board, Player other,  int row, int col) {
	board.editGrid(row,col,pawn);

	
	if (board.checkUp(this, other, row, col) == true) {
	    for (int rowChecker = row-1; rowChecker>0; rowChecker--) {
		if (board.getGrid()[rowChecker][col] == other.getPawn()) {
		    board.editGrid(rowChecker,col,pawn);
		} else {
		    break;
		}
	    }
	}	
    
	
	if (board.checkRight(this,other,row,col) == true) {
	    for (int colChecker = col+1; colChecker <= board.getNumberOfCols(); colChecker++) {
		if (board.getGrid()[row][colChecker] == other.getPawn()) {
		    board.editGrid(row,colChecker,pawn);
		} else {
		    break;
		}
	    }
	}

	if (board.checkLeft(this,other,row,col) == true) {
	    for (int colChecker = col-1; colChecker>0; colChecker--) {
		if (board.getGrid()[row][colChecker] == other.getPawn()) {
		    board.editGrid(row,colChecker,pawn);
		} else {
		    break;
		}
	    }
	}

	if (board.checkDown(this,other,row,col) == true) {
	    for (int rowChecker = row+1; rowChecker <= board.getNumberOfRows(); rowChecker++) {
		if (board.getGrid()[rowChecker][col] == other.getPawn()) {
		    board.editGrid(rowChecker,col,pawn);
		} else {
		    break;
		}
	    }
	}

	if (board.checkUpRight(this,other,row,col) == true) {
	    int colChecker = col+1;
	    for(int rowChecker = row-1; rowChecker>0; rowChecker--) {
		if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
		    board.editGrid(rowChecker,colChecker,pawn);
		    colChecker++;
		} else {
		    break;
		}
	    }
	}

	if (board.checkUpLeft(this,other,row,col) == true) {
	    int colChecker = col-1;
	    for(int rowChecker = row-1; rowChecker>0; rowChecker--) {
		if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
		    board.editGrid(rowChecker,colChecker,pawn);
		    colChecker--;
		} else {
		    break;
		}
	    }
	}

	if (board.checkDownRight(this,other,row,col) == true) {
	    int colChecker = col+1;
	    for (int rowChecker = row+1; rowChecker <= board.getNumberOfRows(); rowChecker++) {
		if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
		    board.editGrid(rowChecker,colChecker,pawn);
		    colChecker++;
		} else {
		    break;
		}
	    }
	}

	if (board.checkDownLeft(this,other,row,col) == true) {
	    int colChecker = col-1;
	    for (int rowChecker = row+1; rowChecker <= board.getNumberOfRows(); rowChecker++) {
		if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
		    board.editGrid(rowChecker,colChecker,pawn);
		    colChecker--;
		} else {
		    break;
		}
	    }
	}

    }

    
    /**
     * Gets the location of the player's next move
     *
     * @param board  the board that the player should find a move
     * @param the player whose turn it is
     * @param the player whose turn it is not
     * @return the location of the spot they will place a pawn
     */
    public abstract int[] getNextMove(ReversiBoard board, Player current, Player other);
    
}