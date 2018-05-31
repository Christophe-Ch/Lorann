package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class MoneyBag extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('A', "purse");
    
	MoneyBag() {
		super(SPRITE, Permeability.COLLECTIBLE);
	}

}
