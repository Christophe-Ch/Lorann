package model.element.motionless;

import model.element.Element;
import model.Permeability;
import model.Sprite;

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
