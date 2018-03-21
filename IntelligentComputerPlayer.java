
package cs1302.p2;

/**
 * This class represents a computer player who plays with logic.
 *
 * @author Frederick Blake Weis
 */
public class IntelligentComputerPlayer extends ComputerPlayer {
    
    /**
     * The constructor for an intelligent computer player.
     *
     * @param pawn   the symbol for the intelligent computer player's pawn
     */
    public IntelligentComputerPlayer(char pawn) {
	super(pawn);
    }

    @Override
    public int[] getNextMove(ReversiBoard board, Player current, Player other) {
        int[] spot = new int[2];
	
	System.out.print("Enter your move, " + this.getPawn() + " player: ");

	
	
	if (board.getGrid()[1][1] == '_') {
	    spot[0] = 1;
	    spot[1] = 1;
	    thinking(1000);
	    System.out.println(spot[0] + " " + spot[1]);
	    thinking(500);
	    return spot;
	}
	if (board.getGrid()[board.getNumberOfRows()][1] == '_') {
	    spot[0] = board.getNumberOfRows();
	    spot[1] = 1;
	    thinking(1000);
	    System.out.println(spot[0] + " " + spot[1]);
	    thinking(500);
	    return spot;
	}
	if (board.getGrid()[1][board.getNumberOfCols()] == '_') {
	    spot[0] = 1;
	    spot[1] = board.getNumberOfCols();
	    thinking(1000);
	    System.out.println(spot[0] + " " + spot[1]);
	    thinking(500);
	    return spot;
	}
	if (board.getGrid()[board.getNumberOfRows()][board.getNumberOfCols()] == '_') {
	    spot[0] = board.getNumberOfRows();
	    spot[1] = board.getNumberOfCols();
	    thinking(1000);
	    System.out.println(spot[0] + " " + spot[1]);
	    thinking(500);
	    return spot;
	}
	
	int maxFlips = 0;
	
	for (int row = 1; row <= board.getNumberOfRows(); row++) {
	    for (int col = 1; col <= board.getNumberOfRows(); col++) {
		int flips = 0;
		
		if (board.getGrid()[row][col] != '_') {
		    continue;
		}

		if (board.checkUp(current,other,row,col) == true) {
		    for (int rowChecker = row-1; rowChecker>0; rowChecker--) {
			if(board.getGrid()[rowChecker][col] == other.getPawn()) {
			    flips++;
			    if (flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    } 
			} else {
			    break;
			}
		    }
		}


		if (board.checkRight(current,other,row,col) == true) {
		    for (int colChecker = col+1; colChecker <= board.getNumberOfCols(); colChecker++) {
			if (board.getGrid()[row][colChecker]  == other.getPawn()) {
			    flips++;
			    if (flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    } 
			} else {
			    break;
			}
		    }
		}


		if (board.checkLeft(current,other,row,col) == true) {
		    for (int colChecker = col-1; colChecker>0; colChecker--) {
			if (board.getGrid()[row][colChecker] == other.getPawn()) {
			    flips++;
			    if(flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    }
			} else {
			    break;
			}
		    }
		}

		if (board.checkDown(current,other,row,col) == true) {
		    for (int rowChecker = row+1; rowChecker <= board.getNumberOfRows(); rowChecker++) {
			if (board.getGrid()[rowChecker][col] == other.getPawn()) {
			    flips++;
			    if (flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    } 
			} else {
			    break;
			}
		    }
		}


		if (board.checkUpRight(current,other,row,col)) {
		    int colChecker = col+1;
		    for(int rowChecker = row-1; rowChecker>0; rowChecker--) {
			if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
			    colChecker++;
			    flips++;
			    if (flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    }
			} else {
			    break;
			}
		    }
		}


		if (board.checkUpLeft(current,other,row,col) == true) {
		    int colChecker = col-1;
		    for (int rowChecker = row-1; rowChecker>0; rowChecker--) {
			if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
			    colChecker--;
			    flips++;
			    if (flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    }
			} else {
			    break;
			}
		    }
		}


		if (board.checkDownRight(current,other,row,col) == true) {
		    int colChecker = col+1;
		    for (int rowChecker = row+1; rowChecker <= board.getNumberOfRows(); rowChecker++) {
			if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
			    colChecker++;
			    flips++;
			    if (flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    }
			} else {
			    break;
			}
		    }
		} 

		
		if (board.checkDownLeft(current,other,row,col) == true) {
		    int colChecker = col-1;
		    for (int rowChecker = row+1; rowChecker <= board.getNumberOfRows(); rowChecker++) {
			if (board.getGrid()[rowChecker][colChecker] == other.getPawn()) {
			    colChecker--;
			    flips++;
			    if (flips > maxFlips) {
				maxFlips = flips;
				spot[0] = row;
				spot[1] = col;
			    }
			} else {
			    break;
			}
		    }
		}
	    }
	}
	thinking(1000);
	System.out.println(spot[0] + " " + spot[1]);
	thinking(500);
	return spot;
    }
    
}