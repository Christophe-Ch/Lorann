package model.element.mobile.auto;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public abstract class Monster extends Mobile {

	public Monster(Sprite sprite, Permeability permeability, ILevel level, int x, int y) {
		super(sprite, permeability, level, x, y);
	}

}
