package motionless;

import element.Element;
import element.Permeability;
import element.Sprite;

abstract class MotionlessElement extends Element {

	/**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
}
