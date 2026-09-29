package tests;

import org.junit.jupiter.api.Test; // Imports for JUnit 
import static org.junit.jupiter.api.Assertions.*;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.GamePiece;
import levelPieces.Boulder;
import levelPieces.Soldier;
import levelPieces.Medusa;
import levelPieces.Spectre;
import levelPieces.Wasp;
import levelPieces.Minotaur;
import levelPieces.Treasure;


public class TestInteractions {
// Wasp:
	public void testWaspInteraction() {
		Drawable[] gameBoard = new Drawable [GameEngine.BOARD_SIZE]; // Blank board, size 21 . 
		Wasp wasp = new Wasp(10); // Index 10 
		gameBoard[10] = wasp; // Place wasp on Idx 10
		assertEquals(InteractionResult.HIT,wasp.interact(gameBoard,10)); // Loop through each title 
		for (int i = 0; i<GameEngine.BOARD_SIZE;i++ ){
			if (i != 10){ // Skip title 10 
				assertEquals(InteractionResult.NONE,wasp.interact(gameBoard,i));// Make sure player is on any other title. 
			}
		}
	}



// Minotaur: 
@Test 
	public void testMinotaurInteraction() {
		Drawable[] gameBoard = new Drawable [GameEngine.BOARD_SIZE]; // Blank board, size 21 . 
		Minotaur minotaur = new Minotaur(5); // Index 5
		gameBoard[5] = minotaur; 
		assertEquals(InteractionResult.HIT, minotaur.interact(gameBoard,5)); // Loop through each title 
		for (int i = 0; i<GameEngine.BOARD_SIZE;i++ ){
			if (i != 5){ // Skip title 10 
				assertEquals(InteractionResult.NONE, minotaur.interact(gameBoard,i));// Make sure player is on any other title. 
			}
		}
	}

// Treasure: Test 3
@Test

	public void testTreasureInteraction() {
		Drawable[] gameBoard = new Drawable [GameEngine.BOARD_SIZE]; // Blank board, size 21 . 
		Treasure treasure = new Treasure(8); 
		gameBoard[10] = treasure; 
		assertEquals(InteractionResult.HIT, treasure.interact(gameBoard,8)); // Loop through each title 
		assertNull (gameBoard[8]);
		gameBoard[8] = treasure;
		for (int i = 0; i<GameEngine.BOARD_SIZE;i++ ){
			if (i != 8){ // Skip title 8
				assertEquals(InteractionResult.NONE, treasure.interact(gameBoard,i));// Make sure player is on any other title. 
			}
		}
	}

// Medusa: Test 4
@Test

	public void testMedusaInteraction() {
		Drawable[] gameBoard = new Drawable [GameEngine.BOARD_SIZE]; // Blank board, size 21 . 
		Medusa medusa = new Medusa(10); 
		gameBoard[10] = medusa; 
		assertEquals(InteractionResult.KILL, medusa.interact(gameBoard,10)); // Loop through each title 
		assertEquals(InteractionResult.KILL, medusa.interact(gameBoard, 11)); // Test 1 title to right (KILL)
		assertEquals(InteractionResult.KILL, medusa.interact(gameBoard,12)); 
		assertEquals(InteractionResult.KILL, medusa.interact(gameBoard,9)); 
		assertEquals(InteractionResult.KILL, medusa.interact(gameBoard,8)); 
		assertEquals(InteractionResult.NONE, medusa.interact(gameBoard,23)); // NONE (too far) . 
		gameBoard[11]=new Boulder();
		for (int i = 0; i<GameEngine.BOARD_SIZE;i++ ){
			if (i != 10){ // Skip title 10
				assertEquals(InteractionResult.NONE, medusa.interact(gameBoard,i));// Make sure player is on any other title. 
			}
		}
	}

// Soldier: Test 5
@Test

	public void testSoldierInteraction() {
		Drawable[] gameBoard = new Drawable [GameEngine.BOARD_SIZE]; // Blank board, size 21 . 
		Soldier soldier = new Soldier(8); 
		gameBoard[4] = soldier; 
		for (int i = 0; i<GameEngine.BOARD_SIZE;i++ ){
				assertEquals(InteractionResult.NONE, soldier.interact(gameBoard,i));// Make sure player is on any other title. 
			}
		}



 // Spectre: Test 6
@Test 
	public void testSpectreInteraction() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Spectre spectre = new Spectre(7);
	 
		gameBoard[7] = spectre;
		
		for (int i = 0; i<GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, spectre.interact(gameBoard,i));
		}
	}
}
