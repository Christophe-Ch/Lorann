package test;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.IOrderPerformer;
import model.ILevel;
import model.IMobile;
import view.ViewFacade;

public class ViewFacadeTest {
	
	private ViewFacade view;
	private ILevel level = new LevelMock(1);
	private IMobile myCharacter = new MobileMock();
	private Rectangle fullView = new Rectangle(0, 0, level.getWidth(), level.getHeight());
	private IMobile[] purses;
    private IMobile[] monsters;
    private IMobile energyBall;
    private IMobile door;
	
	@Before
	public void setUp() throws Exception {
		this.view = new ViewFacade(level, myCharacter, purses, monsters, energyBall, door);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLevel() {
		assertEquals(this.level, this.view.getLevel());
	}

	@Test
	public void testSetLevel() throws IOException {
		this.view.setLevel(this.level);
		assertEquals(this.level, this.view.getLevel());
	}

	@Test
	public void testGetMyCharacter() {
		assertEquals(this.myCharacter, this.view.getMyCharacter());
	}

	@Test
	public void testSetMyCharacter() {
		this.view.setMyCharacter(this.myCharacter);
		assertEquals(this.myCharacter, this.view.getMyCharacter());
	}
	
	@Test
	public void testSetOrderPerformer() {
		IOrderPerformer orderPerformer = new ControllerFacadeMock();
		this.view.setOrderPerformer(orderPerformer);
		assertEquals(orderPerformer, this.view.getOrderPerformer());
	}

	@Test
	public void testGetFullView() {
		assertEquals(this.fullView, this.view.getFullView());
	}

	@Test
	public void testSetFullView() {
		this.view.setFullView(this.fullView);
		assertEquals(this.fullView, this.view.getFullView());
	}

}
