package motionless;

import element.Permeability;
import element.Sprite;

public class CornerWall extends MotionlessElement {
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("bone.png");
    
	CornerWall() {
		super(SPRITE, Permeability.BLOCKING);
	}
}
