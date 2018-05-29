package motionless;

import element.Permeability;
import element.Sprite;

public class VerticalWall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("vertical_bone.png");
    
	VerticalWall() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
