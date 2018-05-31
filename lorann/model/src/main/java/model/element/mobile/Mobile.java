package model.element.mobile;

import java.awt.Point;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;
import model.element.mobile.auto.Spell;

public abstract class Mobile extends Element implements IMobile {
	
	private Point position;
	private boolean alive = true;
	private ILevel level;
	
	private int lastX = 0;
	private int lastY = 0;

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
		this.lastY = -1;
		this.lastX = 0;
	}

	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.lastX = -1;
		this.lastY = 0;
	}

	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.lastY = 1;
		this.lastX = 0;
	}

	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.lastX = 1;
		this.lastY = 0;
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
		return this.position;
	}

	@Override
	public void shoot() {
		int x = this.getX() - lastX;
		int y = this.getY() - lastY;
		this.level.setSpellOnTheLevelXY(x, y, new Spell(this.getLevel(), x, y));
	}
	
	protected void die() {
		this.alive = false;
		this.setHasMoved();
	}
	
	protected ILevel getLevel() {
		return this.level;
	}

}