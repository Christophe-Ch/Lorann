package test;

import static org.junit.Assert.*;

import java.awt.Point;
import org.junit.Before;
import org.junit.Test;

import model.ILevel;
import model.Level;
import model.element.mobile.auto.ThirdMonster;

/**
 * <h1>The Class ThirdMonsterTest tests the methods of the class ThirdMonster.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class ThirdMonsterTest {
	
	/** Instantiates a new level */
	private ILevel level = new Level(1);
	
	/** The monster */
	private ThirdMonster monster;

	/** Instantiates a new monster */
	@Before
	public void setUp() throws Exception {
		this.monster = new ThirdMonster(level, 10, 10);
	}

	/** Tests the move method */
	@Test
	public void testMove() {
		Point old = new Point(monster.getX(), monster.getY());
		monster.move();
		assertNotEquals(old, monster.getPosition());

	}
	
	/** Tests the die method */
	@Test
	public void testDie() {
		monster.die();
		assertEquals(false, monster.isAlive());
	}

}
