package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class EnergyBall extends MotionlessElement {
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('B', "crystal_ball.png");

	EnergyBall() {
		super(SPRITE, Permeability.COLLECTIBLE);
	}
}
