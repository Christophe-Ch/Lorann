package model.element.mobile.auto;

import java.io.IOException;

import model.ILevel;
import model.IMonster;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public abstract class Monster extends Mobile implements IMonster{
	
	private static Sprite deadSprite = new Sprite('M', "floor");

	public Monster(Sprite sprite, ILevel level, int x, int y) {
		super(sprite, Permeability.MONSTER, level, x, y);
		try {
			deadSprite.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isHit() {
		if(this.getLevel().getOnTheLevelXY(this.getX(), this.getY()) instanceof Spell) {
			return true;
		}
		return false;
	}
	
	public abstract void move();
	
	public int collect() {
		this.die();
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(deadSprite);
	}

}
