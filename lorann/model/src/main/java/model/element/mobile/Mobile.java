package model.element.mobile;

import java.awt.Image;
import java.awt.Point;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;
import showboard.IBoard;

public abstract class Mobile extends Element implements IMobile {
	
	private Point position;
	private boolean alive = true;
	private ILevel level;
	private IBoard board;

	public Mobile(Sprite sprite, Permeability permeability, ILevel level) {
		this(sprite, permeability, level, 0, 0);
	}

	public Mobile(Sprite sprite, Permeability permeability, ILevel level, int x, int y) {
		super(sprite, permeability);
		this.level = level;
		this.position = new Point();
		this.getPosition().x = x;
		this.getPosition().y = y;
	}

	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
	}

	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
	}

	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
	}

	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
	}
	
	public void setHasMoved() {
		this.level.setElementHasChanged();
	}

	@Override
	public int getX() {
		return this.getPosition().x;
	}
	
	public void setX(int x) {
		this.getPosition().x = x;
        if (this.isHit()) {
            this.die();
        }
	}

	@Override
	public int getY() {
		return this.getPosition().y;
	}
	
	public void setY(int y) {
		this.getPosition().y = y;
        if (this.isHit()) {
            this.die();
        }
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}

	@Override
	public boolean isHit() {
		return false;
	}

	@Override
	public boolean isOnDoor() {
		return false;
	}

	@Override
	public boolean isOnKey() {
		return false;
	}

	@Override
	public Point getPosition() {
		return null;
	}

	@Override
	public void shoot() {
		this.level.
	}

}
