package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.IOrderPerformer;
import model.IElement;
import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import view.ViewFacade;

public class ViewFacadeTest {
	
	private ILevel level;
	private IMobile myCharacter;
	private ViewFacade view;
	private Rectangle fullView;
	
	@Before
	public void setUp() throws Exception {
		level = new LevelMock();
		myCharacter = new MobileMock();
		view = new ViewFacade(level, myCharacter);
		fullView = new Rectangle(0, 0, level.getWidth(), level.getHeight());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDisplayMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyPressed() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
	}

	@Test
	public void testGetLevel() {
		assertEquals(this.level, this.view.getLevel());
	}

	@Test
	public void testSetLevel() throws IOException {
		final ILevel expected = new LevelMock();
		this.view.setLevel(expected);
		assertEquals(expected, this.view.getLevel());
	}

	@Test
	public void testGetMyCharacter() {
		assertEquals(this.myCharacter, this.view.getMyCharacter());
	}

	@Test
	public void testSetMyCharacter() {
		final IMobile expected = new MobileMock();
		this.view.setMyCharacter(expected);
		assertEquals(expected, this.view.getMyCharacter());
	}

	@Test
	public void testSetOrderPerformer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFullView() {
		assertEquals(fullView, this.view.getFullView());
	}

	@Test
	public void testSetFullView() {
		final Rectangle expected = new Rectangle(0, 0, level.getWidth(), level.getHeight());
		this.view.setFullView(expected);
		assertEquals(expected, this.view.getFullView());
	}

}
