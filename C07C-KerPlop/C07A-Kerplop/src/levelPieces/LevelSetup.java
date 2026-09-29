/*
 * Class: LevelSetup
 * Generate levels and parameters
 * 
 * Authors: Marcus Caro, Trisha Varadaraj
 * Date: 9/25/2026
 */
package levelPieces;

import java.util.ArrayList;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelSetup {
	
	private Drawable[] gameBoard;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	
	private int playerStartLoc;
	private static final Random RNG = new Random();
	
	/*
	 * Determine level and initialize variables
	 */
	public void createLevel(int levelNum) {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		if (levelNum == 1) {
			level1();
		} else if (levelNum == 2) {
			level2();
		}
	}
	
	/*
	 * Method for adding pieces to the level
	 */
	private void addPiece(Drawable piece, int loc) {
		gameBoard[loc] = piece;
		if (piece instanceof GamePiece) {
			interactingPieces.add((GamePiece) piece);
		
		}
		
		if (piece instanceof Moveable) {
			movingPieces.add((Moveable) piece);
		}
	}
	
	/*
	 * Generate a random start location for the player
	 */
	private int randomStartLoc() {
		int loc;
		do {
			loc = RNG.nextInt(GameEngine.BOARD_SIZE);
		} while (gameBoard[loc] != null);
		
		return loc;
	}
	
	
	/*
	 * Generate level 1's pieces and locations
	 */
	private void level1() {
		addPiece(new Boulder(), 2);
		addPiece(new Boulder(), 19);
		
		addPiece(new Treasure(3), 3);
		
		addPiece(new Wasp(5), 5);
		
		addPiece(new Minotaur(0), 0);
		
		addPiece(new Spectre(13), 13);
		
		
		playerStartLoc = randomStartLoc();
		
	}
	
	/*
	 * Generate level 2's pieces and locations
	 */
	private void level2() {
		addPiece(new Boulder(), 19);
		addPiece(new Boulder(), 15);
		
		addPiece(new Treasure(5), 2);
		
		addPiece(new Wasp(3), 3);
		addPiece(new Wasp(4), 4);
		
		addPiece(new Minotaur(8), 8);
		
		addPiece(new Spectre(12), 12);
		
		addPiece(new Medusa(0), 0);
		
		addPiece(new Soldier(18), 18);
		addPiece(new Soldier(1), 1);
		
		
		playerStartLoc = randomStartLoc();
		
	}
	
	/*
	 * Getters for the GameEngine java file
	 */
	public Drawable[] getBoard() {
		return gameBoard;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	
	public int getPlayerStartLoc() {
		return playerStartLoc;
	}
	
}
