package minesweeper;

import java.util.Random;

/**
 * A MineSweeperBoard holds a representation of the contents of the playing
 * field for a Mine Sweeper game. The playing field is represented using a 2
 * dimensional array of integer values. The integer value stored in each cell of
 * the array indicates the icon which will appear in the corresponding cell of
 * the graphical user interface for the game.
 * 
 * @author Grant Braught
 * @author Tim Wahls
 * @author Dickinson College
 * @version Aug 13, 2009
 *
 * @author (Savid B Basnyat)
 * @version 
 */
public class MineSweeperBoard {

	/**
	 * A constant value representing a covered cell. A covered cell is any cell
	 * which does not contains a mine, has not been flagged and has not yet been
	 * uncovered.
	 */
	public static final int COVERED_CELL = -1;

	/**
	 * A constant value representing a a cell that has not been uncovered yet but
	 * contains a mine.
	 */
	public static final int MINE = -2;

	/**
	 * A constant value representing a cell which does not contain a mine but has
	 * had a flag placed on it.
	 */
	public static final int FLAG = -3;

	/**
	 * A constant value representing a cell which contains a mine and has had a flag
	 * placed on it.
	 */
	public static final int FLAGGED_MINE = -4;

	/**
	 * A constant value representing a cell containing a mine that has been
	 * uncovered.
	 */
	public static final int UNCOVERED_MINE = -5;

	/**
	 * A constant value representing the contents of an invalid cell. This value is
	 * returned by the getCell method when an invalid cell is specified.
	 */
	public static final int INVALID_CELL = -10;

	/**
	 * A constant value representing the easiest level of play.
	 */
	public static final int BEGINNER_LEVEL = 1;

	/**
	 * A constant value representing an intermediate level of play.
	 */
	public static final int INTERMEDIATE_LEVEL = 2;

	/**
	 * A constant value representing the hardest level of play.
	 */
	public static final int EXPERT_LEVEL = 3;

	// Define a field to hold your board here, initialize it in your constructors.

	private int[][] msBoard;

	Random rnd = new Random();
	


	/**
	 * Construct a new fixed MineSweeperBoard for testing purposes. The board should
	 * have 3 rows and 4 columns. All cells should contain COVERED_CELL, except that
	 * locations (0, 0) and (2, 1) should contain MINE.
	 */
	public MineSweeperBoard() {
		msBoard = new int[3][4];
		for (int row = 0; row < msBoard.length; row++) {
			for (int col = 0; col < msBoard[row].length; col++) {
				msBoard[row][col] = COVERED_CELL;
			}
			msBoard[0][0] = MINE;
			msBoard[2][1] = MINE;

		}
	}

	/**
	 * Construct a new MineSweeperBoard for play at the specified level. The size of
	 * the board and the number of mines are determined by the level of play. Valid
	 * levels of play are indicated by the constants BEGINNER_LEVEL,
	 * INTERMEDIATE_LEVEL and EXPERT_LEVEL. If an invalid level of play is specified
	 * the new MineSweeperBoard should be created at the BEGINNER_LEVEL. The size of
	 * the board and the number of cells which contain mines is as follows:
	 * 
	 * <pre>
	 * &lt;U&gt;
	 * Level:              Board Size (RxC):   Mines:&lt;/U&gt;        
	 * BEGINNER_LEVEL      5x10                3
	 * INTERMEDIATE_LEVEL  10x15               15
	 * EXPERT_LEVEL        15x20               45
	 * </pre>
	 * 
	 * @param level the level of play.
	 */
	public MineSweeperBoard(int level) {
	
	if (level == EXPERT_LEVEL) {
			msBoard = new int [15][20];
			for (int row = 0; row < msBoard.length; row++) {
				for (int col = 0; col < msBoard[row].length; col++) {
					msBoard[row][col] = COVERED_CELL;
		}
			}
			for (int mineCount = 0; mineCount <45; mineCount++) {
				 int x =rnd.nextInt(15);
				int y = rnd.nextInt(20);
				
				if (msBoard[x][y] == MINE) {
					mineCount = mineCount - 1;
				}
				else {
					msBoard[x][y] = MINE;
				}
			}
			}
	
	else if (level == INTERMEDIATE_LEVEL) {
		msBoard = new int [10][15];
		for (int row = 0; row < msBoard.length; row++) {
			for (int col = 0; col < msBoard[row].length; col++) {
				msBoard[row][col] = COVERED_CELL;
	}
		}
			for (int mineCount = 0; mineCount < 15; mineCount++) {
				 int x =rnd.nextInt(10);
				int y = rnd.nextInt(15);
				
				if (msBoard[x][y] == MINE) {
					mineCount = mineCount - 1;
}
				else {
					msBoard[x][y] = MINE;
				}
			}
	}
	else {
		msBoard = new int [5][10];
		for (int row = 0; row < msBoard.length; row++) {
			for (int col = 0; col < msBoard[row].length; col++) {
				msBoard[row][col] = COVERED_CELL;
	}
		}
			for (int mineCount = 0; mineCount < 3; mineCount++) {
				 int x =rnd.nextInt(5);
					int y = rnd.nextInt(10);
				if (msBoard[x][y] == MINE) {
					mineCount = mineCount - 1;
				}
				else {
					msBoard [x][y] = MINE;
				}
					
			}
			
			
		}
	}

		
	

	/**
	 * Get the number of rows in this MineSweeperBoard.
	 * 
	 * @return the number of rows in this MineSweeperBoard.
	 */
	public int getRows() {
		return msBoard.length;
	}

	/**
	 * Get the number of columns in this MineSweeperBoard.
	 * 
	 * @return the number of columns in this MineSweeperBoard.
	 */
	public int getColumns() {
		return msBoard[0].length;
	}

	/**
	 * Get the number of mines in this MineSweeperBoard.
	 * 
	 * @return the number of mines in this MineSweeperBoard.
	 */
	public int getNumMines() {
		int numMines = 0;
		for (int row = 0; row < msBoard.length; row++) {
			for (int col = 0; col < msBoard[row].length; col++) {
				if (msBoard[row][col] == MINE) {
					numMines = numMines + 1;
				}
			}

		}
		return numMines;
	}

	/**
	 * Get the current contents of the specified cell on this MineSweeperBoard.
	 * 
	 * @param row the row containing the cell.
	 * @param col the column containing the cell.
	 * @return the value contained in the cell specified by row and col, or
	 *         INVALID_CELL if the specified cell is not on the board.
	 */
	public int getCell(int row, int col) {
		if (row < 0 || row >= msBoard.length || col < 0 || col >= msBoard[row].length) {
			return INVALID_CELL;

		} else {
			return msBoard[row][col];
		}
	}

	/**
	 * Count the number of mines that appear in cells that are adjacent to the
	 * specified cell. This method returns the number of adjacent mines but does not
	 * change the contents of the board. It is a helper method for the uncoverCell
	 * method below.
	 * 
	 * @param row the row of the cell.
	 * @param col the column of the cell.
	 * @return the number of mines adjacent to the specified cell. If the specified
	 *         cell is not on the board, return 0.
	 */
	public int numAdjMines(int row, int col) {
		int numMines = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i >= 0 && i < getRows() && j >= 0 && j < getColumns()) {
					if (msBoard[i][j] == MINE || msBoard[i][j] == UNCOVERED_MINE) {
						numMines = numMines + 1;
					}
				}
			}
		}
		return numMines;
	}

	/**
	 * Uncover the specified cell. If the cell already contains a flag it should not
	 * be uncovered. If there is not a mine under the specified cell then the value
	 * in that cell is changed to the number of mines that appear in adjacent cells.
	 * If there is a mine under the specified cell then the cell is changed to the
	 * value UNCOVERED_MINE. If the specified cell is already uncovered or is not on
	 * the board, no change is made to the board.
	 * 
	 * @param row the row of the cell to be uncovered.
	 * @param col the column of the cell to be uncovered.
	 */
	public void uncoverCell(int row, int col) {
		if (msBoard[row][col] == COVERED_CELL) {
			msBoard[row][col] = this.numAdjMines(row, col);
		}
		if (msBoard[row][col] == MINE) {
			msBoard[row][col] = UNCOVERED_MINE;
		}
		if (msBoard[row][col] == FLAG) {
			msBoard[row][col] = FLAG;
		}
		if (msBoard[row][col] == INVALID_CELL) {
			msBoard[row][col] = INVALID_CELL;
		}
	}

	/**
	 * Place or remove a flag from the specified cell. If the cell is currently
	 * covered then place a flag on the cell. If the cell currently contains a flag,
	 * remove that flag but do not uncover the cell. If the cell has already been
	 * uncovered or is not on the board, no change is made to the board.
	 * 
	 * @param row the row of the cell to be flagged/unflagged.
	 * @param col the column of the cell to be flagged/unflagged.
	 */
	public void flagCell(int row, int col) {
		if (msBoard[row][col] == COVERED_CELL) {
			msBoard[row][col] = FLAG;

		} else if (msBoard[row][col] == MINE) {
			msBoard[row][col] = FLAGGED_MINE;
		} else if (msBoard[row][col] == FLAG) {
			msBoard[row][col] = COVERED_CELL;

		} else if (msBoard[row][col] == FLAGGED_MINE) {
			msBoard[row][col] = MINE;
		}
	}

	/**
	 * Uncover all of the cells on the board according to the criterion of the
	 * uncoverCell method.
	 */
	public void revealBoard() {
		for (int i = 0; i < msBoard.length; i++) {
			for (int j = 0; j < msBoard[i].length; j++) {
				this.uncoverCell(i, j);

			}
		}
	}

	/**
	 * Determine if the player has lost the current game. The game is lost if the
	 * player has uncovered a mine.
	 * 
	 * @return true if the current game has been lost and false otherwise.
	 */
	public boolean gameLost() {
		for (int i = 0; i < msBoard.length; i++) {
			for (int j = 0; j < msBoard[i].length; j++) {
				if (msBoard[i][j] == UNCOVERED_MINE) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * Determine if the player has won the current game. The game is won when three
	 * conditions are met:
	 * <OL>
	 * <LI>Flags have been placed on all of the mines.
	 * <LI>No flags have been placed incorrectly.
	 * <LI>All non-flagged cells have been uncovered.
	 * </OL>
	 * 
	 * @return true if the current game has been won and false otherwise.
	 */
	public boolean gameWon() {
		for (int i = 0; i < msBoard.length; i++) {
			for (int j = 0; j < msBoard[i].length; j++) {
				if (msBoard[i][j] == MINE || msBoard[i][j] == FLAG || msBoard[i][j] == COVERED_CELL) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}
}
