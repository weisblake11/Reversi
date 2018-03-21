
package cs1302.p2;

import java.util.Scanner;

/**
 * This class represents a human player
 *
 * @author Frederick Blake Weis
 */
public class Human extends Player {
    
    Scanner asker = new Scanner(System.in);
    
    /**
     * This is the constructor for a human which initializes them as a player
     *
     * @param pawn  the player's pawn symbol
     */
    public Human(char pawn) {
	super(pawn);
    }

    @Override
    public int[] getNextMove(ReversiBoard board, Player current, Player other) {
	int[] spot = new int[2];
	int row;
	int col;
	System.out.print("Enter your move, " + this.getPawn() + " player: ");
	while (true) {
	    if (asker.hasNextInt()) {
		row = asker.nextInt();
		break;
	    } else {
		asker.next();
		continue;
	    }
	}
	while (true) {
	    if (asker.hasNextInt()) {
		col = asker.nextInt();
		break;
	    } else {
		asker.next();
		continue;
	    }
	}
	spot[0] = row;
	spot[1] = col;
	return spot;
    }

}