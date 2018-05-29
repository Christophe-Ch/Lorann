package motionless;

import element.Permeability;
import element.Sprite;

public class ClosedDoor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("gate_closed.png");
    
	ClosedDoor() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
