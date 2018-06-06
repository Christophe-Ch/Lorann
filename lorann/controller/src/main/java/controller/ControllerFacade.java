package controller;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import model.IMobile;
import model.IModel;
import model.IMonster;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderPerformer {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    /** The order. */
    private KeyEvent stackOrder;
    
    /** The speed of refresh. */
    private static int speed = 100;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Starts the game
     */
    public void start() throws SQLException, InterruptedException, IOException {
        while(this.getModel().getMyCharacter().isAlive()) {
        	Thread.sleep(speed);
        	
        	if(this.getModel().getSpell().isAlive())
        		this.getModel().getSpell().move();
        	
        	for(IMobile monster : this.getModel().getMonsters()) {
        		if(monster.isAlive())
        			((IMonster)monster).move();
        	}
        	
        	if(this.getStackOrder() != null) {
        		switch(this.getStackOrder().getKeyCode()) {
        		case KeyEvent.VK_NUMPAD6:
        			this.getModel().getMyCharacter().moveRight();
        			break;
        		case KeyEvent.VK_NUMPAD4:
        			this.getModel().getMyCharacter().moveLeft();
        			break;
        		case KeyEvent.VK_NUMPAD8:
        			this.getModel().getMyCharacter().moveUp();
        			break;
        		case KeyEvent.VK_NUMPAD5:
        			this.getModel().getMyCharacter().moveDown();
        			break;
        		case KeyEvent.VK_NUMPAD9:
        			this.getModel().getMyCharacter().moveUpperRight();
        			break;
        		case KeyEvent.VK_NUMPAD7:
        			this.getModel().getMyCharacter().moveUpperLeft();
        			break;
        		case KeyEvent.VK_NUMPAD3:
        			this.getModel().getMyCharacter().moveBottomRight();
        			break;
        		case KeyEvent.VK_NUMPAD1:
        			this.getModel().getMyCharacter().moveBottomLeft();
        			break;
        		case KeyEvent.VK_SPACE:
        			this.getModel().getMyCharacter().shoot();
        			break;
        		default:
        			this.getModel().getMyCharacter().doNothing();
        			break;
        		}
        		this.stackOrder = null;
        	}
        	else {
        		this.getModel().getMyCharacter().doNothing();
        	}
        }
        if(this.getModel().hasCharacterWon())
        	this.getView().displayMessage("You escaped !");
        else
        	this.getView().displayMessage("You're dead..");
        	
        System.exit(1);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
    /**
     * Stores the order.
     * @param userOrder
     *            the order
     */
    public void performOrder(KeyEvent userOrder) {
    	this.setStackOrder(userOrder);
    }

    /**
     * Gets the order.
     *
     * @return the order
     */
	public KeyEvent getStackOrder() {
		return stackOrder;
	}

	/**
     * Set the order.
     * @param stackOrder
     *            the order
     */
	public void setStackOrder(KeyEvent stackOrder) {
		this.stackOrder = stackOrder;
	}
	
	/**
     * Gets the Order performer.
     *
     * @return the order performer
     */
	public IOrderPerformer getOrderPerformer() {
		return this;
	}
}
