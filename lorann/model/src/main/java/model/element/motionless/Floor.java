package model.element.motionless;

import model.Permeability;
import model.Sprite;

/**
 * The Floor class
 * @author Christophe CHICHMANIAN
 *
 */
public class Floor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ',"floor");
    
    /**
     * Instantiates a new floor
     */
	Floor() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
