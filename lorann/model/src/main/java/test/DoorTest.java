package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ILevel;
import model.Level;
import model.Sprite;
import model.element.mobile.collectible.Door;

public class DoorTest {
	private Door door;
	private ILevel level = new Level(1);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.door = new Door(10, 10, level);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDie() {
		this.door.die();
		assertEquals(false, this.door.isAlive());
	}

}
