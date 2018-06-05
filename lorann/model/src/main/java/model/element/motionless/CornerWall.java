package model.element.motionless;

import model.Permeability;
import model.Sprite;

/**
 * The CornerWall class
 * @author Christophe CHICHMANIAN
 *
 */
public class CornerWall extends MotionlessElement {
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('0',"bone");
    
    /**
     * Instantiates a new CornerWall
     */
	public CornerWall() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
