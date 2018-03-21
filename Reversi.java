
package cs1302.p2;

import java.util.Scanner;

/**
 * The entry point into the program. This method does implement some 
 * logic for handling command line arguments. When two correct strings
 * are provided as arguments, a Reversi game is created with players
 * corresponding to the strings provided. If the arguments are not 
 * formatted correctly, then a usage statement is displayed and the 
 * program exits gracefully.
 *
 *@param args the shell arguments provided to the program
 */
public class Reversi {

    public static void main(String[] args) {
	
	ReversiBoard board = null;
	Player p1 = null;
	Player p2 = null;
	
	
	switch (args.length) {

	case 2:
	    switch (args[0]) {
	    case "Human":
		p1 = new Human('X');
		break;
	    case "RandomComputerPlayer":
		p1 = new RandomComputerPlayer('X');
		break;
	    case "IntelligentComputerPlayer":
		p1 = new IntelligentComputerPlayer('X');
		break;
	    default:
		System.out.println("Usage: java Reversi [PLAYERTYPE] [PLAYERTYPE]");
		System.exit(0);
	    }
	    
	    switch (args[1]) {
	    case "Human":
		p2 = new Human('O');
		break;
	    case "RandomComputerPlayer":
		p2 = new RandomComputerPlayer('O');
		break;
	    case "IntelligentComputerPlayer":
		p2 = new IntelligentComputerPlayer('O');
		break;
	    default:
		System.out.println("Usage: java Reversi [PLAYERTYPE] [PLAYERTYPE]");
		System.exit(0);
	    }
	    break;
	default:
	    System.out.println("Usage: java Reversi [PLAYERTYPE] [PLAYERTYPE]");
	    System.exit(0);
	}

	board = new ReversiBoard(p1,p2);

	int row;
	int col; 
	int[] spot;
	System.out.println();
	System.out.println("Welcome to Reversi! Moves should be entered in \"[row] [column]\" format.");
	boolean stillMyTurn = true;
	int noMoves = 0;
	while (true) {

	    if (noMoves >= 2) {
		board.printBoard();
		System.out.println("No moves left for either player!");
		break;
	    }

	    while (true) {
		board.showAvailableSpots(p1,p2);
		if (board.moveAvailable() == false) {
		    System.out.println("Sorry there are no moves for you.");
		    noMoves++;
		    break;
		}
		spot = p1.getNextMove(board,p1,p2);
		row = spot[0];
		col = spot[1];
		if (p1.moveOkay(board,row,col) == false) {
		    System.out.println("Please try again!");
		    continue;
		}
		p1.makeMove(board,p2,row,col);
		board.resetAvailabilities();
		noMoves = 0;
		break;
	    }
	    
	    if (board.gameIsOver(p1,p2)) {
		board.printBoard();
		break;
	    }
	    if (noMoves >= 2) {
		board.printBoard();
		System.out.println("No moves left for either player!");
		break;
	    }

	    while (true) {
		board.showAvailableSpots(p2,p1);
		if(board.moveAvailable() == false) {
		    System.out.println("Sorry there are no moves for you.");
		    noMoves++;
		    break;
		}
		spot = p2.getNextMove(board,p2,p1);
		row = spot[0];
		col = spot[1];
		if (p2.moveOkay(board,row,col) == false) {
		    System.out.println("Please try again!");
		    continue;
		}
		p2.makeMove(board,p1,row,col);
		board.resetAvailabilities();
		noMoves = 0;
		break;
	    }
	    
	    if (board.gameIsOver(p1,p2)) {
		board.printBoard();
		break;
	    }
	    
	}

	p1.setScore(board.getScore(p1.getPawn()));
	p2.setScore(board.getScore(p2.getPawn()));
		
	
	System.out.println("Game over!");
	System.out.println();
	System.out.println(p1.getPawn() + " player score: " + p1.getScore());
	System.out.println(p2.getPawn() + " player score: " + p2.getScore());
	System.out.println();
	
	if (p1.getScore() > p2.getScore()) {
	    System.out.println("w00t! " + p1.getPawn() + " player, YOU WIN!!!!!");
	} else if (p2.getScore() > p1.getScore()) {
	    System.out.println("w00t! " + p2.getPawn() + " player, YOU WIN!!!!!");
	} else {
	    System.out.println("OH WOW! YOU TIED!!!!! ... cool.");
	}
	System.out.println();

	// Player p1 = new Player("Blake",'X');
	// Player p2 = new Player("Alex",'O');
	// ReversiBoard board = new ReversiBoard(p1,p2);
	// board.printBoard();
	// System.out.println();
	// p1.makeNextMove(board,9,5);
	// board.printBoard();

	// ReversiBoard rev = new ReversiBoard();
	// rev.printBoard();
	// System.out.println(rev.getScore('B'));
	// Player me = new Player("Blake", 'B');
	// me.makeNextMove(rev,1,1);
	// rev.printBoard();
	// System.out.print(rev.getScore('B'));
    }

}