package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ILevel;
import model.element.mobile.MyCharacter;

public class MyCharacterTest {
	private MyCharacter character;
	private ILevel level;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.character = new MyCharacter(10, 10, level);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMoveLeft() {
		this.character.moveLeft();
		assertEquals(9, this.character.getX());
	}
	
	@Test
	public void testMoveRight() {
		this.character.moveRight();
		assertEquals(11, this.character.getX());
	}
	
	@Test
	public void testMoveUp() {
		this.character.moveUp();
		assertEquals(9, this.character.getY());
	}
	
	@Test
	public void testMoveDown() {
		this.character.moveDown();
		assertEquals(11, this.character.getY());
	}
	
	@Test
	public void testIsAlive() {
		assertEquals(true, this.character.isAlive());
	}
	
	

}
