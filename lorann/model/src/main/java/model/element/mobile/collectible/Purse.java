package model.element.mobile.collectible;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public class Purse extends Mobile {

	private static Sprite purseSprite = new Sprite('A', "purse");
	private static Sprite collected = new Sprite('A', "floor");
	
	public Purse(int x, int y, ILevel level) throws IOException {
		super(purseSprite, Permeability.COLLECTIBLE, level, x, y);
		collected.loadImage();
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void die() {
		this.setSprite(collected);
	}

}
