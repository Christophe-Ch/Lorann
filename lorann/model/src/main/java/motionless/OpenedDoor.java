package motionless;

import element.Permeability;
import element.Sprite;

public class OpenedDoor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("gate_open.png");
    
	OpenedDoor() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
