package motionless;

import element.Permeability;
import element.Sprite;

public class HorizontalWall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("horizontal_bone.png");
    
	HorizontalWall() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
