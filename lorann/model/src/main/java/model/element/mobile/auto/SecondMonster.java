package model.element.mobile.auto;

import model.ILevel;
import model.Sprite;

public class SecondMonster extends Monster {
	
	private static Sprite sprite = new Sprite('N', "monster_2");
	
	public boolean goingRight = true;

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
