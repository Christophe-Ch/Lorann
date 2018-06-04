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
        		case KeyEvent.VK_RIGHT:
        			this.getModel().getMyCharacter().moveRight();
        			break;
        		case KeyEvent.VK_LEFT:
        			this.getModel().getMyCharacter().moveLeft();
        			break;
        		case KeyEvent.VK_UP:
        			this.getModel().getMyCharacter().moveUp();
        			break;
        		case KeyEvent.VK_DOWN:
        			this.getModel().getMyCharacter().moveDown();
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
        if(this.getModel().hasCharacterWon()) {
        	this.getView().displayMessage("You escaped !");
        	System.exit(1);
        }
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
     * Stock the order.
     * @param userOrder
     *            the order
     * @return the model
     */
    public void performOrder(KeyEvent userOrder) {
    	this.setStackOrder(userOrder);
    }

    /**
     * Gets the order.
     *
     * @return the model
     */
	public KeyEvent getStackOrder() {
		return stackOrder;
	}

	/**
     * Set the order.
     * @param stackOrder
     *            the order
     * @return the model
     */
	public void setStackOrder(KeyEvent stackOrder) {
		this.stackOrder = stackOrder;
	}
	
	/**
     * Gets the Order performer.
     *
     * @return the model
     */
	public IOrderPerformer getOrderPerformer() {
		return this;
	}
}
