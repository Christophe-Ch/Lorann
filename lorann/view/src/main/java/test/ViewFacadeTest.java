package test;

import static org.junit.Assert.*;

import java.awt.Rectangle;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
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
	
<<<<<<< HEAD
=======
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
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
	private ViewFacade view;
<<<<<<< HEAD
	private ILevel level = new LevelMock(1);
	private IMobile myCharacter = new MobileMock();
	private Rectangle fullView = new Rectangle(0, 0, level.getWidth(), level.getHeight());
	private IMobile[] purses;
    private IMobile[] monsters;
    private IMobile energyBall;
    private IMobile door;
=======
	
	/** The Constant fullView. */
	private Rectangle fullView;
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
	
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Before
	public void setUp() throws Exception {
<<<<<<< HEAD
		this.view = new ViewFacade(level, myCharacter, purses, monsters, energyBall, door);
=======
		level = new LevelMock();
		myCharacter = new MobileMock();
		view = new ViewFacade(level, myCharacter, purses, monsters, energyBall, door);
		fullView = new Rectangle(0, 0, level.getWidth(), level.getHeight());
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
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
		this.view.setLevel(this.level);
		assertEquals(this.level, this.view.getLevel());
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
		this.view.setMyCharacter(this.myCharacter);
		assertEquals(this.myCharacter, this.view.getMyCharacter());
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
		this.view.setFullView(this.fullView);
		assertEquals(this.fullView, this.view.getFullView());
	}

}
