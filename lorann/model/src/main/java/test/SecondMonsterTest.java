package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ILevel;
import model.Level;
import model.element.mobile.auto.SecondMonster;
import model.element.motionless.HorizontalWall;

/**
 * <h1>The Class SecondMonsterTest tests the methods of the class SecondMonster.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class SecondMonsterTest {
	
	/** Instantiates a new level */
	private ILevel level = new Level(1);
	
	/** The monster */
	private SecondMonster monster;

	/** Instantiates a new monster */
	@Before
	public void setUp() throws Exception {
		this.monster = new SecondMonster(level, 10, 10);
	}

	/** Tests the move method */
	@Test
	public void testMove() {
		level.setOnTheLevelXY(11, 10, new HorizontalWall());
		assertEquals(false, monster.moveRight());
		monster.move();
		assertEquals(true, monster.moveLeft());
		level.setOnTheLevelXY(7, 10, new HorizontalWall());
		monster.move();
		assertEquals(true, monster.moveRight());
	}
	
	/** Tests the die method */
	@Test
	public void testDie() {
		monster.die();
		assertEquals(false, monster.isAlive());
	}

}
