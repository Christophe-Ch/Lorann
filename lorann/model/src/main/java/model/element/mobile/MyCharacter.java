package model.element.mobile;

import java.io.IOException;
import java.util.ArrayList;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.mobile.auto.Spell;

/**
 * The MyCharacter class
 * @author Christophe CHICHMANIAN
 *
 */
public class MyCharacter extends Mobile{
	
	/** Bottom sprite */
	private static Sprite lorann_b = new Sprite(' ', "lorann_b");
	
	/** Bottom-left sprite */
	private static Sprite lorann_bl = new Sprite(' ' ,"lorann_bl");
	
	/** Bottom-right sprite */
	private static Sprite lorann_br = new Sprite(' ' ,"lorann_br");
	
	/** Left sprite */
	private static Sprite lorann_l = new Sprite(' ' ,"lorann_l");
	
	/** Right sprite */
	private static Sprite lorann_r = new Sprite(' ' ,"lorann_r");
	
	/** Up sprite */
	private static Sprite lorann_u = new Sprite(' ' ,"lorann_u");
	
	/** Upper-left sprite */
	private static Sprite lorann_ul = new Sprite(' ' ,"lorann_ul");
	
	/** Upper-right sprite */
	private static Sprite lorann_ur = new Sprite(' ' ,"lorann_ur");
	
	/** List of all the purses */
	private ArrayList<IMobile> purses;
	
	/** List of all the monsters */
	private ArrayList<IMobile> monsters;
	
	/** The key */
	private IMobile energyBall;
	
	/** The door */
	private IMobile door;
	
	/** The spell */
	private IMobile spell;
	
	/** The score */
	private int score = 0;
	
	/** Boolean value that indicates if the player has the key */
	private boolean hasTheKey = false;
	
	/** Boolean value that indicates if the player has won */
	private boolean won = false;
	
	/** Array of all the sprites */
	private static Sprite[] sprites;
	
	/**
	 * Instantiates a MyCharacter object
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 * @param level
	 * 		The level in which the character stands
	 * @throws IOException
	 */
	public MyCharacter(int x, int y, ILevel level) throws IOException {
		super(lorann_r, Permeability.BLOCKING, level);
		
		sprites = new Sprite[8];
		
		lorann_b.loadImage();
		lorann_bl.loadImage();
		lorann_br.loadImage();
		lorann_l.loadImage();
		lorann_u.loadImage();
		lorann_ul.loadImage();
		lorann_ur.loadImage();
		
		sprites[0] = lorann_r;
		sprites[1] = lorann_br;
		sprites[2] = lorann_b;
		sprites[3] = lorann_bl;
		sprites[4] = lorann_l;
		sprites[5] = lorann_ul;
		sprites[6] = lorann_u;
		sprites[7] = lorann_ur;
		
		this.initX(x);
		this.initY(y);
		
		this.purses = new ArrayList<>();
		this.monsters = new ArrayList<>();
	}

	@Override
	public void doNothing() {
		
		if(isHit(this.getX(), this.getY())) {this.die();}
		else if(this.isOnSpell(this.getX(), this.getY())) 
			this.spell.collect();
		
		int index = 0;
		for(int i = 0; i < sprites.length; i++) {
			if(sprites[i] == this.getSprite()) {
				index = i;
			}
		}
		
		if(index < 7)
			this.setSprite(sprites[index + 1]);
		else
			this.setSprite(sprites[0]);
		
		this.setHasMoved();
	}
	
	/** 
	 * Checks if something happens to the player (if he's hit by a monster, etc...)
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 */
	public void specialCase(int x, int y) {
		if(isHit(this.getX(), this.getY()))
			this.die();
		else if(this.isOnKey(x, this.getY())) {
			energyBall.collect();
			hasTheKey = true;
			door.collect();
		}
		else if(this.isOnDoor(x, this.getY())) {
			if(hasTheKey) {
				this.won = true;
				this.die();
			}
		}
		else if(this.isOnPurse(x, this.getY())) {}
		else if(this.isOnSpell(x, this.getY())) {
			this.spell.collect();
		}
	}
	
	@Override
	public boolean moveLeft() {
		super.moveLeft();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_bl);
		return true;
	}
	
	@Override
	public boolean moveRight() {
		super.moveRight();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_ur);
		return true;
	}
	
	@Override
	public boolean moveUp() {
		super.moveUp();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_ul);
		return true;
	}
	
	@Override
	public boolean moveDown() {
		super.moveDown();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_br);
		return true;
	}
	
	/**
	 * Checks if the player is on a purse
	 * @param newX
	 * 		X coordinate
	 * @param newY
	 * 		Y coordinate
	 */
	public boolean isOnPurse(int newX, int newY) {
		for(IMobile purse : purses) {
			if(purse.getX() == newX && purse.getY() == newY) {
				purse.collect();
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if the player is on the key
	 * @param newX
	 * 		X coordinate
	 * @param newY
	 * 		Y coordinate
	 */
	public boolean isOnKey(int newX, int newY) {
		if(energyBall.getX() == newX && energyBall.getY() == newY)
			return true;
		
		return false;
	}
	
	/**
	 * Checks if the player is on the door
	 * @param newX
	 * 		X coordinate
	 * @param newY
	 * 		Y coordinate
	 */
	public boolean isOnDoor(int newX, int newY) {
		if(door.getX() == newX && door.getY() == newY)
			return true;
		
		return false;
	}
	
	/**
	 * Checks if the player is on the spell
	 * @param newX
	 * 		X coordinate
	 * @param newY
	 * 		Y coordinate
	 */
	public boolean isOnSpell(int newX, int newY) {
		if(spell.getX() == newX && spell.getY() == newY)
			return true;
		return false;
	}
	
	/**
	 * Adds the purse to the player
	 * @param purse
	 * 		Purse to add
	 */
	public void addPurse(IMobile purse) {
		purses.add(purse);
	}
	
	/**
	 * Adds the key to the player
	 * @param energyBall
	 * 		Key to add
	 */
	public void addEnergyBall(IMobile energyBall) {
		this.energyBall = energyBall;
	}
	
	/**
	 * Adds a monster to the player
	 * @param monster
	 * 		Monster to add
	 */
	public void addMonster(IMobile monster) {
		this.monsters.add(monster);
	}
	
	/**
	 * Adds the door to the player
	 * @param door
	 * 		Door to add
	 */
	public void addDoor(IMobile door) {
		this.door = door;
	}
	
	/**
	 * Adds the spell to the player
	 * @param spell
	 * 		Spell to add
	 */
	public void addSpell(IMobile spell) {
		this.spell = spell;
		for (IMobile monster : monsters) {
			((Spell)this.spell).addMonster(monster);
		}
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Gets if the player has won
	 */
	public boolean hasWon() {
		return this.won;
	}
	
	@Override
	public boolean isHit(int newX, int newY) {
		for(IMobile monster : this.monsters) {
			if(monster.getX() == newX && monster.getY() == newY && monster.isAlive()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Makes the spell spawn at a specific location
	 */
	public void shoot() {
		if(!spell.isAlive()) {
			int direction = lastY != 0 ? (lastY == -1 ? 2 : 1) : (lastX == -1 ? 3 : 4);
			((Spell)this.spell).spawn(this.getX() - lastX, this.getY() - lastY, direction);
		}
	}

}
