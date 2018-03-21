 
package cs1302.p2;

/** This class represents a board for the game reversi
 *
 * @author Frederick Blake Weis
 */
public class ReversiBoard extends Board {

    private boolean gameOver;

    /**
     * Class constructor creating a reversi board object
     */
    public ReversiBoard(Player p1, Player p2) {
	super(8,8,'.');
	gameOver = false;
	editGrid(4,4,p1.getPawn());
	editGrid(5,5,p1.getPawn());
	editGrid(4,5,p2.getPawn());
	editGrid(5,4,p2.getPawn());
    }

    /**
     * Checks if the game is over or still ongoing
     *
     * @param onePlayer     one of the player's in the game
     * @param otherPlayer   the other player in the game
     * @return  whether or not the game is over
     */
    public boolean gameIsOver(Player onePlayer, Player otherPlayer) {
	boolean existsOnePlayerPawn = false;
	boolean existsOtherPlayerPawn = false;
	boolean existsTile = false;
	
	for (int row = 1; row <= getNumberOfRows(); row++) {
	    for (int col = 1; col <= getNumberOfCols(); col++) {
		if (getGrid()[row][col] == onePlayer.getPawn()) {
		    existsOnePlayerPawn = true;
		}
		if (getGrid()[row][col] == otherPlayer.getPawn()) {
		    existsOtherPlayerPawn = true;
		}
		if (getGrid()[row][col] == tile) {
		    existsTile = true;
		}
	    }
	}
	if (existsOnePlayerPawn == false || existsOtherPlayerPawn == false || existsTile == false) {
	    return true;
	} else {
	    return false;
	}
    }
    


    /**
     * Determines whether the current player has a possible play
     *
     * @return whether or not the player can play
     */
    public boolean moveAvailable() {
	for (int row = 1; row <= getNumberOfRows(); row++) {
	    for (int col = 1; col <= getNumberOfCols(); col++) {
		if (getGrid()[row][col] == '_') {
		    return true;
		}
	    }
	}
	return false;
    }


    /**
     * Takes off all available spot marks from last move
     */
    public void resetAvailabilities() {
	for (int row = 1; row <= getNumberOfRows(); row++) {
	    for (int col = 1; col <= getNumberOfCols(); col++) {
		if (getGrid()[row][col] == '_') {
		    editGrid(row,col,tile);
		}
	    }
	}
    }

    /**
     * Displays the board with available tiles to lay a pawn.
     *
     * @param current  the player whose turn it is
     * @param other    the player whose turn it is not
     */
    public void showAvailableSpots(Player current, Player other) {
	for(int row = 1; row <= getNumberOfRows(); row++) {
	    for(int col = 1; col <= getNumberOfCols(); col++) {
		if (getGrid()[row][col] != tile) {
		    continue;
		}
		if (checkUp(current,other,row,col) == true || checkRight(current,other,row,col) == true || checkLeft(current,other,row,col) == true || checkDown(current,other,row,col) == true) {
		    editGrid(row, col, '_');
		}
		if (checkUpRight(current,other,row,col) == true || checkUpLeft(current,other,row,col) == true || checkDownRight(current,other,row,col) == true || checkDownLeft(current,other,row,col) == true) {
		    editGrid(row,col,'_');
		}
	    }
	}
	printBoard();
    }

    /**
     * Helper method to check the tiles above each spot
     *
     * @param current  the player whose turn it is
     * @param other    the player whose turn it is not
     * @param row      the row position of tile to check
     * @param col      the column position of tile to check
     * @return whether or not it will flip pawns above
     */
    public boolean checkUp(Player current, Player other, int row, int col) {
	if (getGrid()[row-1][col] != other.getPawn()) {
	    return false;
	}
	for(int checker = row - 2; checker > 0; checker--) {
	    if (getGrid()[checker][col] == current.getPawn()) {
		return true;
	    } else if (getGrid()[checker][col] == other.getPawn()) {
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }
    
    
    /**
     * Helper method to check the tiles to the right of each spot
     *
     * @param current  the player whose turn its is
     * @param other    the player whose turn it is not
     * @param row      the row position of tile to check
     * @param col      the column position of the tile to check
     * @return whether or not it will flip pawns to the right
     */
    public boolean checkRight(Player current, Player other, int row, int col) {
	if (getGrid()[row][col+1] != other.getPawn()) {
	    return false;
	}
	for (int checker = col + 2; checker <= getNumberOfCols(); checker++) {
	    if (getGrid()[row][checker] == current.getPawn()) {
		return true;
	    } else if (getGrid()[row][checker] == other.getPawn()) {
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }


    /**
     * Helper method to check the tiles to the left of each spot
     *
     * @param current  the player whose turn it is
     * @param other    the player whose turn it is not
     * @param row      the row position of the tile to check
     * @param col      the column position of the tile to check
     * @return whether or not it will flip pawns to the left
     */
    public boolean checkLeft(Player current, Player other, int row, int col) {
	if (getGrid()[row][col-1] != other.getPawn()) {
	    return false;
	}
	for (int checker = col - 2; checker > 0; checker--) {
	    if (getGrid()[row][checker] == current.getPawn()) {
		return true;
	    } else if (getGrid()[row][checker] == other.getPawn()) {
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }


    /**
     * Helper method to check the tiles below each spot
     *
     * @param current  the player whose turn it is
     * @param other    the player whose turn it is not
     * @param row      the row position of the tile to check
     * @param col      the column position of the tile to check 
     * @return whether or not it will flip pawns to the left
     */
    public boolean checkDown(Player current, Player other, int row, int col) {
	if (getGrid()[row+1][col] != other.getPawn()) {
	    return false;
	}
	for (int checker = row + 2; checker <= getNumberOfRows(); checker++) {
	    if (getGrid()[checker][col] == current.getPawn()) {
		return true;
	    } else if (getGrid()[checker][col] == other.getPawn()) {
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }


    /**
     * Helper method to check the tiles diagonally up and right of each spot
     *
     * @param current  the player whose turn it is
     * @param other    the player whose turn it is not
     * @param row      the row position of the tile to check
     * @param col      the column position of the tile to check
     * @return whether or not it will flip flaws diagonally up to the right
     */
    public boolean checkUpRight(Player current, Player other, int row, int col) {
	if(getGrid()[row-1][col+1] != other.getPawn()) {
	    return false;
	}
	int colChecker = col+2;
	for (int rowChecker = row-2; rowChecker > 0; rowChecker--) {
	    if (getGrid()[rowChecker][colChecker] == current.getPawn()) {
		return true;
	    } else if (getGrid()[rowChecker][colChecker] == other.getPawn()) {
		colChecker++;
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }


    /**
     * Helper method to check the tiles diagonally up and to the left of each spot 
     *
     * @param current  the player whose turn it is
     * @param other    the player whose turn it is not
     * @param row      the row position of the tile to check
     * @param col      teh column position of the tile to check
     * @return whether or not it will flip pawns diagonally up and to the left
     */
    public boolean checkUpLeft(Player current, Player other, int row, int col) {
	if (getGrid()[row-1][col-1] != other.getPawn()) {
	    return false;
	}
	int colChecker = col-2;
	for (int rowChecker = row-2; rowChecker > 0; rowChecker--) {
	    if (getGrid()[rowChecker][colChecker] == current.getPawn()) {
		return true;
	    } else if (getGrid()[rowChecker][colChecker] == other.getPawn()) {
		colChecker--;
		continue;
	    } else {
		return false;
	    }
	} 
	return false;
    }


    /**
     * Helper method to check the tiles diagonally down and to the right of each spot
     *
     * @param current  the player whose turn it is
     * @param other    the player whose turn it is not
     * @param row      the row position of the tile to check
     * @param col      the column position of the tile to check
     * @return whether or not it will flip pawns diagonally down and to the right
     */
    public boolean checkDownRight(Player current, Player other, int row, int col) {
	if (getGrid()[row+1][col+1] != other.getPawn()) {
	    return false;
	}
	int colChecker = col+2;
	for (int rowChecker = row+2; rowChecker <= getNumberOfRows(); rowChecker++) {
	    if (getGrid()[rowChecker][colChecker] == current.getPawn()) {
		return true;
	    } else if (getGrid()[rowChecker][colChecker] == other.getPawn()) {
		colChecker++;
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }


    /** Helper method to check the tiles diagonally down and to the left of each spot
     *
     * @param current  the player whose turn it is 
     * @param other    the player whose turn it is not
     * @param row      the row position of the tile to check
     * @param col      the column position of the tile to check
     * @return whether or not it will flip pawns diagonally down and to the left 
     */
    public boolean checkDownLeft(Player current, Player other, int row, int col) {
	if (getGrid()[row+1][col-1] != other.getPawn()) {
	    return false;
	}
	int colChecker = col-2;
	for (int rowChecker = row+2; rowChecker <= getNumberOfRows(); rowChecker++) {
	    if (getGrid()[rowChecker][colChecker] == current.getPawn()) {
		return true;
	    } else if (getGrid()[rowChecker][colChecker] == other.getPawn()) {
		colChecker--;
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }
}