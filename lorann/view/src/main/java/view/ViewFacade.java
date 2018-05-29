package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
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
	
	/** The view. */
    private int view;
	
	/** The Constant squareSize. */
    private static final int squareSize = 32;

    /** The Constant closeView. */
    private Rectangle fullView;
    

	/**
     * Instantiates a new view facade.
     */
    public ViewFacade(ILevel level, IMobile myCharacter) {
        this.setLevel(level);
        this.setMyCharacter(myCharacter);
        this.getMyCharacter().getSprite().loadImage();
        this.setFullView(new Rectangle(0, 0, this.getLevel().getWidth(), this.getLevel().getHeight()));
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
		boardFrame.setDimension(new Dimension(this.getLevel().getWidth(), this.getLevel().getHeight()));
        boardFrame.setDisplayFrame(this.fullView);
        boardFrame.setSize(this.fullView.width * squareSize, this.fullView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(false);
        boardFrame.setFocusTraversalKeysEnabled(false);
		
		for (int x = 0; x < this.getLevel().getWidth(); x++) {
            for (int y = 0; y < this.getLevel().getHeight(); y++) {
                boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyCharacter());

        this.getLevel().getObservable().addObserver(boardFrame.getObserver());

        boardFrame.setVisible(true);
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
            this.getOrderPerformer().performOrder(keyEvent);
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
     * Get the Character
     */
	public IMobile getMyCharacter() {
		return myCharacter;
	}

	/**
     * Set the Character
     */
	public void setMyCharacter(IMobile myCharacter) {
		this.myCharacter = myCharacter;
	}

	/**
     * Get the OrderPerformer
     */
	private IOrderPerformer getOrderPerformer() {
		return orderPerformer;
	}

	/**
     * Set the OrderPerformer
     */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
	
	/**
     * Get the view.
     */
    public int getView() {
		return view;
	}

    /**
     * Set the view.
     */
	public void setView(int view) {
		this.view = view;
	}

	/**
     * Get the full view.
     */
	public Rectangle getFullView() {
		return fullView;
	}

	/**
     * Set the full view.
     */
	public void setFullView(Rectangle fullView) {
		this.fullView = fullView;
	}
}
