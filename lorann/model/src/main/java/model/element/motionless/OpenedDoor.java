package model.element.motionless;

import model.Permeability;
import model.Sprite;

/**
 * The OpenedDoor class
 * @author Christophe CHICHMANIAN
 *
 */
public class OpenedDoor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('D', "gate_open");
    
    /**
     * Instantiates a new OpenedDoor
     */
	OpenedDoor() {
		super(SPRITE, Permeability.DOOR);
	}

}
