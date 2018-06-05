package model.element.mobile.collectible;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

/**
 * The EnergyBall class
 * @author Christophe CHICHMANIAN
 *
 */
public class EnergyBall extends Mobile {

	/** Sprite of the key */
	private static Sprite ballSprite = new Sprite('B', "crystal_ball");
	
	/** Sprite of the floor */
	private static Sprite collected = new Sprite('B', "floor");
	
	/**
	 * Instantiates a new EnergyBall
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 * @param level
	 * 		The level in which the key stands
	 * @throws IOException
	 */
	public EnergyBall(int x, int y, ILevel level) throws IOException {
		super(ballSprite, Permeability.COLLECTIBLE, level, x, y);
		collected.loadImage();
	}

	@Override
	public void doNothing() {}
	
	/** Collects the key */
	public int collect() {
		if(this.isAlive()) {
			this.die();
		}
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(collected);
	}

}
