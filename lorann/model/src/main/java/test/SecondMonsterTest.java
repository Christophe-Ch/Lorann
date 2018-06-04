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
import model.element.mobile.auto.SecondMonster;
import model.element.mobile.auto.Spell;
import model.element.motionless.HorizontalWall;

public class SecondMonsterTest {
	private ILevel level = new Level(1);
	private SecondMonster monster;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.monster = new SecondMonster(level, 10, 10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsHit() throws IOException {
		this.level.setOnTheLevelXY(10, 10, new Spell(level, 10, 10, new Sprite(' ')));
		assertEquals(true, this.monster.isHit());
	}
	
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
	
	@Test
	public void testDie() {
		monster.die();
		assertEquals(false, monster.isAlive());
	}

}
