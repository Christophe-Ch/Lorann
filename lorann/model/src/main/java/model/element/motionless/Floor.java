package motionless;

import element.Permeability;
import element.Sprite;

public class Floor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("Floor.png");
    
	Floor() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
