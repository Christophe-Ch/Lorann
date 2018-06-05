package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;

import showboard.BoardFrame;
import model.ILevel;
import model.IMobile;


/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard
 * @version 1.0
 */
public class ViewFacade implements IView, KeyListener, Runnable {
	
	/** The Level. */
	private ILevel level;
	
	/** The character. */
	private IMobile myCharacter;
	
	/** The order performer. */
	private IOrderPerformer orderPerformer;
	
	/** The Constant squareSize. */
    private static final int squareSize = 64;

    /** The Constant fullView. */
    private Rectangle fullView;
    
    /** The purses. */
    private IMobile[] purses;
    
    /** The monsters. */
    private IMobile[] monsters;
    
    /** The energy ball. */
    private IMobile energyBall;
    
    /** The door. */
    private IMobile door;
    
    /** The spell. */
    private IMobile spell;

	/**
     * Instantiates a new view facade.
<<<<<<< HEAD
     * 
     * @param level
     * 		the level
     * @param myCharacter
     * 		the character
     * @param purses
     * 		the list of all the purses
     * @param monsters
     * 		the list of all the monsters
     * @param energyBall
     * 		the key
     * @param door
     * 		the door
     * @param spell
     * 		the spell
=======
	 * 
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
     */
    public ViewFacade(ILevel level, IMobile myCharacter, IMobile[] purses, IMobile[] monsters, IMobile energyBall, IMobile door, IMobile spell) {
        try {
			this.setLevel(level);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        this.setMyCharacter(myCharacter);
        try {
			this.getMyCharacter().getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.setFullView(new Rectangle(0, 0, this.getLevel().getWidth(), this.getLevel().getHeight()));
        SwingUtilities.invokeLater(this);
        
        this.purses = purses;
        this.monsters = monsters;
        this.energyBall = energyBall;
        this.door = door;
        this.spell = spell;
    }

    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

	@Override
	public void run() {
		BoardFrame boardFrame = new BoardFrame("Lorann", false);
		boardFrame.setDimension(new Dimension(this.getLevel().getWidth(), this.getLevel().getHeight()));
        boardFrame.setDisplayFrame(this.fullView);
        boardFrame.setSize(this.fullView.width * squareSize - 32, this.fullView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
		
		for (int x = 0; x < this.getLevel().getWidth(); x++) {
            for (int y = 0; y < this.getLevel().getHeight(); y++) {
                boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
            }
        }
		
		for(IMobile purse : purses) {
			try {
				purse.getSprite().loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			boardFrame.addPawn(purse);
		}
		
		for(IMobile monster : monsters) {
			try {
				monster.getSprite().loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			boardFrame.addPawn(monster);
		}
		
		try {
			this.energyBall.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.door.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.spell.getSprite().loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boardFrame.addPawn(this.energyBall);
		
		boardFrame.addPawn(this.door);
		
		boardFrame.addPawn(this.spell);
        
		boardFrame.addPawn(this.getMyCharacter());
		
		

        this.getLevel().getObservable().addObserver(boardFrame.getObserver());

        boardFrame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		//NOP
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		this.getOrderPerformer().performOrder(keyEvent);
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		//NOP
	}

	/**
     * Get the Level.
     * 
     * @return the level
     */
	public ILevel getLevel() {
		return this.level;
	}

	/**
     * Set the Level.
     * 
     * @param level
     * 		the level
     * 
	 * @throws IOException
	 * 		if the image of the sprite doesn't exist
     */
	public void setLevel(ILevel level) throws IOException {
		this.level = level;
		int y = 0;
		int x = 0;
		for (y = 0; y < this.getLevel().getHeight(); y++) {
			for (x = 0; x < this.getLevel().getWidth(); x++) {
				this.getLevel().getOnTheLevelXY(x,y).getSprite().loadImage();
			}
		}
	}

	/**
     * Get the Character.
     * 
     * @return the character
     */
	public IMobile getMyCharacter() {
		return this.myCharacter;
	}

	/**
     * Set the Character.
     * 
     * @param myCharacter
     * 		the character
     */
	public void setMyCharacter(IMobile myCharacter) {
		this.myCharacter = myCharacter;
	}

	/**
     * Get the OrderPerformer.
     * 
     * @return the order performer
     */
	public IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
     * Set the OrderPerformer.
     * 
     * @param orderPerformer
     * 		the order performer
     */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/**
     * Get the full view.
     * 
     * @return the full view rectangle
     */
	public Rectangle getFullView() {
		return this.fullView;
	}

	/**
     * Set the full view.
     * 
     * @param fullView
     * 		the full view rectangle
     */
	public void setFullView(Rectangle fullView) {
		this.fullView = fullView;
	}
}
