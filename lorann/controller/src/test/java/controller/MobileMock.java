package controller;

import java.awt.Image;
import java.awt.Point;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The Class MobileMock imitates the Mobile class.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class MobileMock implements IMobile {

	/** The position */
	private Point position;
	
	/** The level */
	private ILevel level;
	
	/** Is alive */
	private boolean alive;
	
	/**
     * Instantiates a new mobile mock
     *
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
	public MobileMock(int x, int y) {
		this.position = new Point();
		this.getPosition().x = x;
		this.getPosition().y = y;
		this.alive = true;
	}
	
	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#moveUp()
     */
	@Override
	public boolean moveUp() {
		if(this.setY(this.getY() - 1)) {
			return true;
		}
		return false;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#moveLeft()
     */
	@Override
	public boolean moveLeft() {
		if(this.setX(this.getX() - 1)) {
			return true;
		}
		return false;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#moveDown()
     */
	@Override
	public boolean moveDown() {
		if(this.setY(this.getY() + 1)) {
			return true;
		}
		return false;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#moveRight()
     */
	@Override
	public boolean moveRight() {
		if(this.setX(this.getX() + 1)) {
			return true;
		}
		return false;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#getX()
     */
	@Override
	public int getX() {
		return this.getPosition().x;
	}
	
	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#setX()
     */
	public boolean setX(int x) {
		if (!this.isOnWall(x, this.getY())) {
			this.getPosition().x = x;
			return true;
        }
		return false;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#getY()
     */
	@Override
	public int getY() {
		return this.getPosition().y;
	}
	
	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#setY()
     */
	public boolean setY(int y) {
		if (!this.isOnWall(this.getX(), y)) {
			this.getPosition().y = y;
			return true;
        }
		return false;
	}
	
	/*
     * (non-Javadoc)
     * @see model.element.Mobile#isOnWall()
     */
	public boolean isOnWall(int newX, int newY) {
		return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.BLOCKING);
	}
	
	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#isHit()
     */
	@Override
	public boolean isHit(int newX, int newY) {
		return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.MONSTER);
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#getPosition()
     */
	@Override
	public Point getPosition() {
		return this.position;
	}
	
	/*
     * (non-Javadoc)
     * @see model.element.Mobile#getLevel()
     */
	protected ILevel getLevel() {
		return this.level;
	}
	
	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#shoot()
     */
	@Override
	public void shoot() {}
	
	/*
     * (non-Javadoc)
     * @see model.element.Mobile#setPosition()
     */
	public boolean setPosition(int x, int y) {
		if(this.getLevel().getOnTheLevelXY(x, y).getPermeability() != Permeability.BLOCKING) {
			this.getPosition().x = x;
			this.getPosition().y = y;
			return true;
		}
		return false;
	}
	
	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#move()
     */
	@Override
	public void move() {}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#doNothing()
     */
	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#isAlive()
     */
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return this.alive;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IMobile#collect()
     */
	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * (non-Javadoc)
     * @see model.element.Element#getSprite()
     */
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see model.element.Element#getPermeability()
     */
	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see model.element.Element#getImage()
     */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void die() {
		this.alive = false;
	}

	@Override
	public boolean moveUpperRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveUpperLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveBottomRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveBottomLeft() {
		// TODO Auto-generated method stub
		return false;
	}

}
