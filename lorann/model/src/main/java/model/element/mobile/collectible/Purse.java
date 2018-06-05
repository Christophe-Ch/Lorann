package model.element.mobile.collectible;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

/**
 * The Purse class
 * @author Christophe CHICHMANIAN
 *
 */
public class Purse extends Mobile {

	/** Sprite of the purse */
	private static Sprite purseSprite = new Sprite('A', "purse");
	
	/** Sprite of the floor */
	private static Sprite collected = new Sprite('A', "floor");
	
	/** Amount of points given when collected */
	private static int points = 10;
	
	/**
	 * Instantiates a new purse
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 * @param level
	 * 		The level in which the door stands
	 * @throws IOException
	 * 		if the image of a sprite doesn't exist
	 */
	public Purse(int x, int y, ILevel level) throws IOException {
		super(purseSprite, Permeability.COLLECTIBLE, level, x, y);
		collected.loadImage();
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub

	}
	
	/** Collects the purse and gives points */
	public int collect() {
		if(this.isAlive()) {
			this.die();
			return points;
		}
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(collected);
	}

}
