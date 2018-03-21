
package cs1302.p2;

import java.util.Random;

/**
 * This class represents a computer player who randomly chooses an open spot to place a pawn
 *
 * @author Frederick Blake Weis
 */
public class RandomComputerPlayer extends ComputerPlayer {
    
    Random rand = new Random();

    public RandomComputerPlayer(char pawn) {
	super(pawn);
    }
    

    @Override
	public int[] getNextMove(ReversiBoard board, Player current, Player other) {
	int[] spot = new int[2];
	System.out.print("Enter your move, " + this.getPawn() + " player: ");

	int numberOf_ = 0;

	for (int row = 1; row <= board.getNumberOfRows(); row++) {
	    for (int col = 1; col<= board.getNumberOfCols(); col++) {
		if (board.getGrid()[row][col] == '_') {
		    numberOf_++;
		}
	    }
	}
	
	spot[0] = 0;
	spot[1] = 0;
	int whichOne = rand.nextInt(numberOf_);
	int now = 0;

	for (int row = 1; row<= board.getNumberOfRows(); row++) {
	    for (int col = 1; col <= board.getNumberOfCols(); col++) {
		if (board.getGrid()[row][col] == '_') {
		    if (now == whichOne) {
			spot[0] = row;
			spot[1] = col;
			thinking(1000);
			System.out.println(spot[0] + " " + spot[1]);
			thinking(500);
			return spot;
		    } else {
			now++;
		    }
		}
	    }
	}
	return spot;

    }

}