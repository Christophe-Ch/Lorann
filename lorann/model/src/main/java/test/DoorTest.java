package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ILevel;
import model.Level;
import model.element.mobile.collectible.Door;

/**
 * <h1>The Class DoorTest tests the methods of the class Door.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class DoorTest {
	
	/** The door */
	private Door door;
	
	/** Instantiates a new level */
	private ILevel level = new Level(1);

	/** 
	 * Instantiates a new door
	 * 
	 * @throws Exception
	 * 		if the instantiation fails
	 */
	@Before
	public void setUp() throws Exception {
		this.door = new Door(10, 10, level);
	}

	/** Tests the die method */
	@Test
	public void testDie() {
		this.door.die();
		assertEquals(false, this.door.isAlive());
	}
	
	@Test
	public void testCollect() {
		door.collect();
		assertEquals(false, door.isAlive());
	}

}
