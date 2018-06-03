package model.element.mobile.auto;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public class Spell extends Mobile{

	private static Sprite first_sprite = new Sprite(' ', "fireball_1");
	private static Sprite second_sprite = new Sprite(' ', "fireball_2");
	private static Sprite third_sprite = new Sprite(' ', "fireball_3");
	private static Sprite fourth_sprite = new Sprite(' ', "fireball_4");
	private static Sprite fifth_sprite = new Sprite(' ', "fireball_5");
	private static Sprite dead_sprite;
	
	private int direction;
	
	public Spell(ILevel level, int x, int y, int direction, Sprite deadSprite) {
		super(first_sprite, Permeability.SPELL, level, x, y);
		this.direction = direction;
		this.dead_sprite = deadSprite;
	}
	
	public void move() {
		switch (direction) {
			case 1: // Up
				if(!moveUp()) {
					moveDown();
					direction = 2;
				}
				break;
			case 2: // Down
				if(!moveDown()) {
					moveUp();
					direction = 1;
				}
				break;
			case 3: // Right
				if(!moveRight()) {
					moveLeft();
					direction = 4;
				}
				break;
			case 4: // Left
				if(!moveLeft()) {
					moveRight();
					direction = 3;
				}
				break;
		}
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int collect() {
		this.setSprite(dead_sprite);
		return 0;
	}
	
	@Override
	public void die() {
		collect();
	}

}
