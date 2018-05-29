package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class CornerWall extends MotionlessElement {
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("bone.png");
    
	CornerWall() {
		super(SPRITE, Permeability.BLOCKING);
	}
}
