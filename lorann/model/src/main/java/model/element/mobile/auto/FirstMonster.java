package model.element.mobile.auto;

import model.ILevel;
import model.Sprite;

/**
 * The FirstMonster class
 * @author Christophe CHICHMANIAN
 *
 */
public class FirstMonster extends Monster {
	
	/** Sprite of the monster */
	private static Sprite sprite = new Sprite('M', "monster_1");
	
	/** Boolean value that indicates wheter the monster has to go up or down */
	public boolean goingUp = true;

	/**
	 * @see Monster constructor
	 * @param level
	 * 		the level
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 */
	public FirstMonster(ILevel level, int x, int y) {
		super(sprite, level, x, y);
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
	}

	@Override
	public void move() {
		if(this.goingUp) {
			if(!this.moveUp()) {
				this.moveDown();
				goingUp = false;
			}
		}
		else {
			if(!this.moveDown()) {
				this.moveUp();
				goingUp = true;
			}
		}
	}

	

}
