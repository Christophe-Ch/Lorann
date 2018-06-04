package model.element.mobile.auto;

import java.io.IOException;
import java.util.ArrayList;

import model.ILevel;
import model.IMobile;
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
	
	private Sprite[] sprites;
	
	private int direction;
	
	private ArrayList<IMobile> monsters;
	
	public Spell(ILevel level, int x, int y, Sprite deadSprite) throws IOException {
		super(deadSprite, Permeability.SPELL, level, x, y);
		this.dead_sprite = deadSprite;
		this.first_sprite.loadImage();
		this.second_sprite.loadImage();
		this.third_sprite.loadImage();
		this.fourth_sprite.loadImage();
		this.fifth_sprite.loadImage();
		
		this.sprites = new Sprite[5];
		
		this.sprites[0] = first_sprite;
		this.sprites[1] = second_sprite;
		this.sprites[2] = third_sprite;
		this.sprites[3] = fourth_sprite;
		this.sprites[4] = fifth_sprite;
		
		direction = 0;
		
		this.collect();
		
		monsters = new ArrayList<>();
	}
	
	public void move() {
		if(this.isAlive()) {
			
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
			
			int index = 0;
			for(int i = 0; i < sprites.length; i++) {
				if(sprites[i] == this.getSprite()) {
					index = i;
				}
			}
			
			if(index < 4)
				this.setSprite(sprites[index + 1]);
			else
				this.setSprite(sprites[0]);
			
			for (IMobile monster : monsters) {
				if(monster.getPosition().getX() == this.getX() && monster.getPosition().getY() == this.getY())
				{
					monster.collect();
					this.collect();
					break;
				}
			}
			
		}
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int collect() {
		this.die();
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(dead_sprite);
		this.getPosition().x = 0;
		this.getPosition().y = 0;
	}
	
	public void spawn(int x, int y, int direction) {
		if(this.setPosition(x, y))
		{
			this.direction = direction;
			this.setSprite(first_sprite);
			this.revive();		}
	}

	public void addMonster(IMobile monster) {
		this.monsters.add(monster);
	}

}
