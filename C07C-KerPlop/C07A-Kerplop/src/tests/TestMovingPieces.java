/*
 * Class: TestMovingPieces
 * Test that movement works for the Spectre and Soldier pieces
 * 
 * Authors: Marcus Caro, Trisha Varadaraj
 * Date: 9/28/2026
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test; // Imports for JUnit 

import gameEngine.Drawable;
import gameEngine.GameEngine;

import levelPieces.Boulder;
import levelPieces.Soldier;
import levelPieces.Spectre;


public class TestMovingPieces {

	/*
	 * Test if spectre movement works as intended
	 */
@Test
	public void testSpectreMovement() {
		Drawable[] edgeBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		for (int i = 0;i<GameEngine.BOARD_SIZE ;i++){
			if (i < 8 ||i > 10) {
				edgeBoard[i] = new Boulder();
			}
		}
		Spectre spectre =new Spectre(9);
		edgeBoard[9] = spectre;
		int Count8= 0;
		int Count9 = 0;
		int Count10 = 0;
		for (int i = 0; i < 200;i++) { 
			spectre.move(edgeBoard, 0);
			int currentLoc = spectre.getLocation();
			assertTrue(currentLoc>=8&& currentLoc <= 10);
			if (currentLoc == 8) {
				Count8++;
			}
			if (currentLoc == 9) {
				Count9++;
			}
			if (currentLoc == 10) {
				Count10++;
			}
				
		}
		
		assertTrue(Count10> 0);
		assertTrue(Count9 > 0);
		assertTrue(Count8 > 0);
		
	}

	/*
	 * Test if soldier movement works as intended
	 */
@Test
	public void testSoldierMovement() {
		Drawable[] edgeBoard = new Drawable[GameEngine.BOARD_SIZE];
		Soldier soldier = new Soldier(5); // Soldier at position 5 . 
		edgeBoard[5]=soldier; 
		soldier.move(edgeBoard,0); // Move soldier
		assertEquals(6,soldier.getLocation()); // Make sure at 5 
		assertEquals(soldier,edgeBoard[6]);
		assertNull(edgeBoard[5]);
		edgeBoard[7] =new Boulder(); // Place Boulder at position 7 (block) to block path . 
		soldier.move (edgeBoard,0); // Move Soldier 
		assertEquals(5,soldier.getLocation());
		assertEquals(soldier, edgeBoard[5]); // Make sure Soldier Object is at  index 5 . 
		assertNull(edgeBoard[6]); // Make sure Position 6 is empty (NULL)
	
	}
}