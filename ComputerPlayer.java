
package cs1302.p2;

/**
 * This class represents the computer player. It is an abstract method as there are different types of computer players.
 *
 * @author Frederick Blake Weis
 */
public abstract class ComputerPlayer extends Player {
   
    /**
     * The sole constructor of a computer player which calls the parent constructor in the parent class
     *
     * @param pawn   the symbol that the player's pawn will resesmble.
     */
    public ComputerPlayer(char pawn) {
	super(pawn);
    }

    /** 
     * Pauses the running of the program for a set amount of time
     *
     * @param time  the amount of time to pause the program
     */
    public static void thinking(int time) {
	try {
	    Thread.sleep(time);
	} catch (Exception e) {System.out.println("oop");}
    }

}