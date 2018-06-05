package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ILevel;
import model.element.mobile.MyCharacter;

/**
 * <h1>The Class MyCharacterTest tests the methods of the class MyCharacter.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class MyCharacterTest {
	
	/** The character */
	private MyCharacter character;
	
	/** The level */
	private ILevel level;

	/**
	 *  Instantiates a new character 
	 * 
	 * @throws Exception
	 * 		if the instantiation fails
	 */
	@Before
	public void setUp() throws Exception {
		this.level = new Level(1);
		this.character = new MyCharacter(5, 5, level);
		this.character.addEnergyBall(this.level.getEnergyBall());
		this.character.addDoor(this.level.getDoor());
		this.character.addSpell(this.level.getSpell());
	}

	/** Tests the moveLeft method */
	@Test
	public void testMoveLeft() {
		this.character.moveLeft();
		assertEquals(4, this.character.getX());
	}
	
	/** Tests the moveRight method */
	@Test
	public void testMoveRight() {
		this.character.moveRight();
		assertEquals(6, this.character.getX());
	}
	
	/** Tests the moveUp method */
	@Test
	public void testMoveUp() {
		this.character.moveUp();
		assertEquals(4, this.character.getY());
	}
	
	/** Tests the moveDown method */
	@Test
	public void testMoveDown() {
		this.character.moveDown();
		assertEquals(6, this.character.getY());
	}
	
	/** Tests the isAlive method */
	@Test
	public void testIsAlive() {
		assertEquals(true, this.character.isAlive());
	}
	
	

}
