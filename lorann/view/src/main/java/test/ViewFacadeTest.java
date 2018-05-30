package test;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.ILevel;
import model.IMobile;
import view.ViewFacade;

public class ViewFacadeTest {

	private ILevel level;
	private IMobile myCharacter;
	private ViewFacade view;
	
	@Before
	public void setUp() throws Exception {
		view = new ViewFacade(level, myCharacter);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDisplayMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyTyped() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyPressed() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyReleased() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLevel() {
		assertEquals(this.level, this.view.getLevel());
	}

	@Test
	public void testSetLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMyCharacter() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMyCharacter() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOrderPerformer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFullView() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFullView() {
		fail("Not yet implemented");
	}

}
