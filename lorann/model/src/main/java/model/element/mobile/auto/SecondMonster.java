package model.element.mobile.auto;

import model.ILevel;
import model.Sprite;

/**
 * The SecondMoster class
 * @author Christophe CHICHMANIAN
 *
 */
public class SecondMonster extends Monster {
	
	/** Sprite of the monster */
	private static Sprite sprite = new Sprite('N', "monster_2");
	
	/** Boolean value that indicates wheter the monster has to go to the right or the left */
	public boolean goingRight = true;

	/**
	 * @see Monster constructor
	 * @param level
	 * 		the level
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 */
	public SecondMonster(ILevel level, int x, int y) {
		super(sprite, level, x, y);
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
	}

	@Override
	public void move() {
		if(this.goingRight) {
			if(!this.moveRight()) {
				this.moveLeft();
				goingRight = false;
			}
		}
		else {
			if(!this.moveLeft()) {
				this.moveRight();
				goingRight = true;
			}
		}
	}
}
