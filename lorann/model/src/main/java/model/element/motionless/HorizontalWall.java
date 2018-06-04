package model.element.motionless;

import model.Permeability;
import model.Sprite;

/**
 * The HorizontalWall class
 * @author Christophe CHICHMANIAN
 *
 */
public class HorizontalWall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('-', "horizontal_bone");
  
    /**
     * Instantiates a new HorizontallWall
     */
	HorizontalWall() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
