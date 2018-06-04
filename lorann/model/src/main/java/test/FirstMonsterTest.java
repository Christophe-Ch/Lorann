package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ILevel;
import model.Level;
import model.Sprite;
import model.element.mobile.auto.FirstMonster;
import model.element.mobile.auto.Spell;
import model.element.motionless.HorizontalWall;

public class FirstMonsterTest {
	private ILevel level = new Level(1);
	private FirstMonster monster;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.monster = new FirstMonster(level, 9, 8);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsHit() throws IOException {
		this.level.setOnTheLevelXY(9, 8, new Spell(level, 9, 8, new Sprite(' ')));
		assertEquals(true, this.monster.isHit());
	}
	
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
	
	@Test
	public void testDie() {
		monster.die();
		assertEquals(false, monster.isAlive());
	}

}
