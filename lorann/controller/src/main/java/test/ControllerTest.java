package test;

import static org.junit.Assert.*;

import java.awt.Button;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.ControllerFacade;
import model.IMobile;
import model.IModel;
import view.IView;


public class ControllerTest {
	private ControllerFacade controller;
	private IView view = new ViewMock();
	private IModel model = new ModelMock();
	private IMobile myCharacter = new MobileMock(10, 10);


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.controller = new ControllerFacade (view, model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetView() {
		assertEquals(this.view, this.controller.getView());
	}
	
	@Test
	public void testGetModel() {
		assertEquals(this.model, this.controller.getModel());

	}
	
	@Test
	public void testPerformOrder() {
		KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
		this.controller.performOrder(keyEvent);
		assertEquals(keyEvent, controller.getStackOrder());
	}
	
	@Test
	public void testGetOrderPerformer() {
		assertEquals(this.controller, this.controller.getOrderPerformer());
	}
	
	@Test
	public void testGetStackOrder() {
		KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
		this.controller.setStackOrder(keyEvent);
		assertEquals(keyEvent, this.controller.getStackOrder());
	}
	
	@Test
	public void testSetStackOrder() {
		KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
		this.controller.setStackOrder(keyEvent);
		assertEquals(keyEvent, this.controller.getStackOrder());
	}
	
	@Test
	public void testStart() throws SQLException, InterruptedException, IOException {
		KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
		this.controller.setStackOrder(keyEvent);
		this.controller.start();
		assertEquals(11, this.myCharacter.getX());
	}
	

}
