package motionless;

import element.Permeability;
import element.Sprite;

public class MoneyBag extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite("purse.png");
    
	MoneyBag() {
		super(SPRITE, Permeability.COLLECTIBLE);
	}

}
