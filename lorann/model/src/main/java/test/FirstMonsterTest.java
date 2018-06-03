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
import model.element.mobile.auto.FirstMonster;
import model.element.mobile.auto.Monster;
import model.element.mobile.auto.Spell;

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
		this.monster = new FirstMonster(new Sprite('M'), level, 10, 10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testisHit() {
		this.level.setOnTheLevelXY(10, 10, new Spell(level, 9, 9));
		assertEquals(true, this.monster.isHit());
	}

}
