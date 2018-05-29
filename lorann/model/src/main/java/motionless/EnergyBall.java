package motionless;

import element.Permeability;
import element.Sprite;

public class EnergyBall extends MotionlessElement {
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("crystal_ball.png");

	EnergyBall() {
		super(SPRITE, Permeability.COLLECTIBLE);
	}
}
