package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class ClosedDoor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('S',"gate_closed");
    
	ClosedDoor() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
