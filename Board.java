
package cs1302.p2;

/** This class represents a game board.
 *
 * @author Frederick Blake Weis
 */
public abstract class Board {
    
    private int numberOfRows;
    private int numberOfCols;
    protected char tile;
    private char[][] grid;


    /**
     * Class constructor creating a board object with specified size and tile symbols.
     *
     * @param rows  the number of rows on the board
     * @param cols  the number of columns on the board
     * @param tile  the symbols to represent an empty tile on the board.
     */
    public Board(int rows, int cols, char tile) {
	numberOfRows = rows;
	numberOfCols = cols;
	this.tile = tile;
	createGrid(rows, cols, tile);
    }


    /**
     * Creates a grid of characters which represent the tiles on the grid.
     *
     * @param rows  the number of rows on the board
     * @param cols  the number of columns in the board
     * @param tile  the symbols to represent empty tiles on the board.
     */
    public void createGrid(int rows, int cols, char tile) {
	grid = new char[rows + 2][cols + 2];

	for (int row = 0; row <  rows + 2; row++) {
	    for (int  col = 0; col < cols + 2; col++) {
		if (row == 0 || row == rows + 2 || col == 0 || col == cols + 2) {
		    grid[row][col] = '!';
		} else {
		    grid[row][col] = tile; 
		}
	    } 
	} // for loop
    } // createGrid


    /**
     * Changes the current state of a tile on the board. 
     *
     * @param row           the row of the tile that will changed.
     * @param col           the column of the tile that will be changed.
     * @param symbol        the new symbol that will take control of the tile.
     */
    public void editGrid(int row, int col, char symbol) {
	grid[row][col] = symbol;
    }


    /**
     * Prints the board to the screen.
     */
    public void printBoard() {
	System.out.println();
	for(int row = 0; row < numberOfRows + 1; row++) {
	    for (int col = 0; col < numberOfCols + 1; col++) {
		if (row == 0 && col == 0) {
		    System.out.print("  ");
		} 
		else if (row == 0) {
		    System.out.print((col) + " ");
		}
		else if (col == 0) {
		    System.out.print((row) + " ");
		}
		else {
		    System.out.print(grid[row][col] + " ");
		}
	    }
	    System.out.println();
	}// for loop
	System.out.println();
    }// printBoard


    /**
     * Calcuates the score of the player specified
     *
     * @param pawn  the symbol for the player's pawn
     * @return  the number of tiles occupied by their pawn.
     */
    public int getScore(char pawn) {
	int count = 0;
	for (int row = 1; row <= numberOfRows; row++ ) {
	    for (int col = 1; col <= numberOfCols; col ++) {
		if (grid[row][col] == pawn) {
		    count++;
		}
	    }
	}
	return count;
    }


    /**
     * Returns the number of rows on a board
     *
     * @return  number of rows on the board
     */
    public int getNumberOfRows() {
	return numberOfRows;
    }


    /**
     * Returns the number of columns on a board
     *
     * @return number of columns on the board
     */
    public int getNumberOfCols() {
	return numberOfCols;
    }

    /**
     * Returns the current state of the grid
     *
     * @return the current grid
     */
    public char[][] getGrid() {
	return grid;
    }
}