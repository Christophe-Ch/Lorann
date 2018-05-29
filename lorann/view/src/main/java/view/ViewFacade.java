package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, KeyListener, Runnable {
	
	/** The Level. */
	private ILevel level;
	
	/** The character. */
	private IMobile myCharacter;
	
	/** The order performer. */
	private IOrderPerformer orderPerformer;

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(ILevel level, IMobile myCharacter) {
        this.setLevel(level);
        this.setMyCharacter(myCharacter);
        this.getMyCharacter().getSprite().loadImage();
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void run() {
		BoardFrame boardFrame = new BoardFrame("Lorann", false);
		boardFrame.addKeyListener(this);;
		
		for (int x = 0; x < this.getLevel().getWidth(); x++) {
            for (int y = 0; y < this.getLevel().getHeight(); y++) {
                boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyCharacter());

        this.getLevel().getObservable().addObserver(boardFrame.getObserver());
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		//NOP
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		try {
            this.getOrderPerformer().performOrder(keyEvent.getKeyCode());
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		//NOP
	}

	/**
     * Get the Level.
     */
	public ILevel getLevel() {
		return level;
	}

	/**
     * Set the Level.
     */
	public void setLevel(ILevel level) {
		this.level = level;
		for (int x = 0; x < this.getLevel().getWidth(); x++) {
			for (int y = 0; y < this.getLevel().getHeight(); y++) {
				this.getLevel().setOnTheLevelXY(x,y).getSprite().loadImage();
			}
		}
	}

	/**
     * Get the Character.
     */
	public IMobile getMyCharacter() {
		return myCharacter;
	}

	/**
     * Set the Character.
     */
	public void setMyCharacter(IMobile myCharacter) {
		this.myCharacter = myCharacter;
	}

	/**
     * Get the OrderPerformer.
     */
	private IOrderPerformer getOrderPerformer() {
		return orderPerformer;
	}

	/**
     * Set the OrderPerformer.
     */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
	
	

}
