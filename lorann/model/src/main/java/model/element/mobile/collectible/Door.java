package model.element.mobile.collectible;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

/**
 * The Door class
 * @author Christophe CHICHMANIAN
 *
 */
public class Door extends Mobile {

	/** Sprite of the door when it's open */
	private static Sprite opened = new Sprite('D', "gate_open");
	
	/** Sprite of the door when it's closed */
	private static Sprite closed = new Sprite('S', "gate_closed");
	
	/**
	 * Instantiates a new door
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 * @param level
	 * 		The level in which the door stands
	 * @throws IOException
	 * 		if the image of a sprite doesn't exist
	 */
	public Door(int x, int y, ILevel level) throws IOException {
		super(closed, Permeability.COLLECTIBLE, level, x, y);
		opened.loadImage();
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub

	}
	
	/** Opens the door */
	public int collect() {
		if(this.isAlive()) {
			this.die();
		}
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(opened);
	}

}
