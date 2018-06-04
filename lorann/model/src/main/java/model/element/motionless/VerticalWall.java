package model.element.motionless;

import model.Permeability;
import model.Sprite;

/**
 * The VerticalWall class
 * @author Christophe CHICHMANIAN
 *
 */
public class VerticalWall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('|', "vertical_bone");
    
    /**
     * Instantiates a new VerticalWall
     */
	VerticalWall() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
