package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ILevel;
import model.Level;
import model.element.mobile.auto.FirstMonster;
import model.element.motionless.HorizontalWall;

/**
 * <h1>The Class FirstMonsterTest tests the methods of the class FirstMonster.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class FirstMonsterTest {
	
	/** Instantiates a new level */
	private ILevel level = new Level(1);
	
	/** The monster */
	private FirstMonster monster;

	/**
	 *  Instantiates a new monster 
	 * 
	 * @throws Exception
	 * 		if the instantiation fails
	 */
	@Before
	public void setUp() throws Exception {
		this.monster = new FirstMonster(level, 9, 8);
	}

	
	/** Tests the move method */
	@Test
	public void testMove() {
		level.setOnTheLevelXY(9, 7, new HorizontalWall());
		assertEquals(false, monster.moveUp());
		monster.move();
		assertEquals(true, monster.moveDown());
		level.setOnTheLevelXY(9, 10, new HorizontalWall());
		monster.move();
		assertEquals(true, monster.moveUp());
	}
	
	/** Tests the die method */
	@Test
	public void testDie() {
		monster.die();
		assertEquals(false, monster.isAlive());
	}

}
