package model.element.mobile;

import java.awt.Point;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;

/**
 * <h1>The Mobile class</h1>
 * @author Christophe CHICHMANIAN
 *
 */
public abstract class Mobile extends Element implements IMobile {
	
	/** Position of the Mobile element */
	private Point position;
	
	/** Defines whether the mobile element is alive or not */
	private boolean alive = true;
	
	/** The level in which the mobile element stands */
	private ILevel level;
	
	/** Last movement on the X axis */
	protected int lastX = 0;
	
	/** Last movement on the Y axis */
	protected int lastY = 0;

	/**
	 * Instantiates a new Mobile object
	 * @param sprite
	 * 		Sprite of the element
	 * @param permeability
	 * 		Permeability of the element
	 * @param level
	 * 		The level in which the element stands
	 */
	public Mobile(Sprite sprite, Permeability permeability, ILevel level) {
		this(sprite, permeability, level, 0, 0);
	}

	/**
	 * Instantiates a new Mobile object
	 * @param sprite
	 * 		Sprite of the element
	 * @param permeability
	 * 		Permeability of the element
	 * @param level
	 * 		The level in which the element stands
	 * @param x
	 * 		X position
	 * @param y
	 * 		Y position
	 */
	public Mobile(Sprite sprite, Permeability permeability, ILevel level, int x, int y) {
		super(sprite, permeability);
		this.level = level;
		this.position = new Point();
		this.getPosition().x = x;
		this.getPosition().y = y;
	}

	/**
	 * Moves to the top on the level
	 * 
	 * @return Boolean value that indicates whether the element has moved or not
	 */
	@Override
	public boolean moveUp() {
		if(this.setY(this.getY() - 1)) {
			this.lastY = -1;
			this.lastX = 0;
			return true;
		}
		return false;
	}

	/**
	 * Moves to the left on the level
	 * 
	 * @return Boolean value that indicates whether the element has moved or not
	 */
	@Override
	public boolean moveLeft() {
		if(this.setX(this.getX() - 1)) {
			this.lastX = -1;
			this.lastY = 0;
			return true;
		}
		return false;
	}

	/**
	 * Moves to the bottom on the level
	 * 
	 * @return Boolean value that indicates whether the element has moved or not
	 */
	@Override
	public boolean moveDown() {
		if(this.setY(this.getY() + 1)) {
			this.lastY = 1;
			this.lastX = 0;
			return true;
		}
		return false;
	}

	/**
	 * Moves to the right on the level
	 * 
	 * @return Boolean value that indicates whether the element has moved or not
	 */
	@Override
	public boolean moveRight() {
		if(this.setX(this.getX() + 1)) {
			this.lastX = 1;
			this.lastY = 0;
			return true;
		}
		return false;
	}
	
	/**
	 * Notifies the level the element has moved
	 */
	public void setHasMoved() {
		this.level.setElementHasChanged();
	}

	@Override
	public int getX() {
		return this.getPosition().x;
	}
	
	/**
	 * Checks if the element can move to the wanted location and moves it if possible
	 * @param x
	 * 		X coordinate
	 * @return Boolean value that indicates whether the element has moved or not
	 */
	public boolean setX(int x) {
		if (!this.isOnWall(x, this.getY())) {
			this.getPosition().x = x;
			return true;
        }
		return false;
	}

	@Override
	public int getY() {
		return this.getPosition().y;
	}
	
	/**
	 * Checks if the element can move to the wanted location and moves it if possible
	 * @param y
	 * 		Y coordinate
	 * @return Boolean value that indicates whether the element has moved or not
	 */
	public boolean setY(int y) {
		if (!this.isOnWall(this.getX(), y)) {
			this.getPosition().y = y;
			return true;
        }
		return false;
	}
	
	/** 
	 * Sets the X coordinate
	 * @param x
	 * 		X coordinate
	 */
	public void initX(int x) {
		this.getPosition().x = x;
	}
	
	/** 
	 * Sets the Y coordinate
	 * @param y
	 * 		Y coordinate
	 */
	public void initY(int y) {
		this.getPosition().y = y;
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}

	/**
	 * Checks if there is a wall at a specific location
	 * @param newX
	 * 		X coordinate
	 * @param newY
	 * 		Y coordinate
	 * @return Boolean value that indicates whether there is a wall or not
	 */
	public boolean isOnWall(int newX, int newY) {
		return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.BLOCKING);
	}
	
	@Override
	public boolean isHit(int newX, int newY) {
		return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.MONSTER);
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Kills the mobile element
	 */
	public void die() {
		this.alive = false;
	}
	
	/**
	 * Revives the mobile element
	 */
	public void revive() {
		this.alive = true;
	}
	
	/**
	 * Gets the level
	 * @return The level
	 */
	protected ILevel getLevel() {
		return this.level;
	}
	
	/**
	 * Spawns a spell (@see MyCharacter class)
	 */
	public void shoot() {}
	
	public boolean setPosition(int x, int y) {
		if(this.getLevel().getOnTheLevelXY(x, y).getPermeability() != Permeability.BLOCKING) {
			this.getPosition().x = x;
			this.getPosition().y = y;
			return true;
		}
		return false;
	}
	
	/**
	 * Defines a generic behavior for the movement of the mobile element (@see monsters and spell)
	 */
	public void move() {}

}