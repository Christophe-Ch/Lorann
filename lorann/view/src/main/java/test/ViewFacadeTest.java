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

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard & Christophe Chichmanian & Charlotte Bénard & François Mouton
 * @version 1.0
 */
public class ViewFacadeTest {
	
	/** The Level. */
	private ILevel level;
	
	/** The character. */
	private IMobile myCharacter;
    
    /** The purses. */
    private IMobile[] purses;
    
    /** The monsters. */
    private IMobile[] monsters;
    
    /** The energy ball. */
    private IMobile energyBall;
    
    /** The door. */
    private IMobile door;
    
    /** The view. */
	private ViewFacade view;
	
	/** The Constant fullView. */
	private Rectangle fullView;
	
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Before
	public void setUp() throws Exception {
		level = new LevelMock();
		myCharacter = new MobileMock();
		view = new ViewFacade(level, myCharacter, purses, monsters, energyBall, door);
		fullView = new Rectangle(0, 0, level.getWidth(), level.getHeight());
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@After
	public void tearDown() throws Exception {
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Test
	public void testGetLevel() {
		assertEquals(this.level, this.view.getLevel());
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Test
	public void testSetLevel() throws IOException {
		final ILevel expected = new LevelMock();
		this.view.setLevel(expected);
		assertEquals(expected, this.view.getLevel());
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Test
	public void testGetMyCharacter() {
		assertEquals(this.myCharacter, this.view.getMyCharacter());
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Test
	public void testSetMyCharacter() {
		final IMobile expected = new MobileMock();
		this.view.setMyCharacter(expected);
		assertEquals(expected, this.view.getMyCharacter());
	}
	
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Test
	public void testSetOrderPerformer() {
		IOrderPerformer orderPerformer = new ControllerFacadeMock();
		this.view.setOrderPerformer(orderPerformer);
		assertEquals(orderPerformer, this.view.getOrderPerformer());
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Test
	public void testGetFullView() {
		assertEquals(this.fullView, this.view.getFullView());
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Test
	public void testSetFullView() {
		final Rectangle expected = new Rectangle(0, 0, level.getWidth(), level.getHeight());
		this.view.setFullView(expected);
		assertEquals(expected, this.view.getFullView());
	}

}
