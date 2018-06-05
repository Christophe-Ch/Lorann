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
		this.character = new MyCharacter(10, 10, level);
	}

	/** Tests the moveLeft method */
	@Test
	public void testMoveLeft() {
		this.character.moveLeft();
		assertEquals(9, this.character.getX());
	}
	
	/** Tests the moveRight method */
	@Test
	public void testMoveRight() {
		this.character.moveRight();
		assertEquals(11, this.character.getX());
	}
	
	/** Tests the moveUp method */
	@Test
	public void testMoveUp() {
		this.character.moveUp();
		assertEquals(9, this.character.getY());
	}
	
	/** Tests the moveDown method */
	@Test
	public void testMoveDown() {
		this.character.moveDown();
		assertEquals(11, this.character.getY());
	}
	
	/** Tests the isAlive method */
	@Test
	public void testIsAlive() {
		assertEquals(true, this.character.isAlive());
	}
	
	

}
