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
	
	public Spell(ILevel level, int x, int y) {
		super(first_sprite, Permeability.SPELL, level, x, y);
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}

}
