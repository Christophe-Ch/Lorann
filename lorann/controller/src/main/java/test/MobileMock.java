package test;

import java.awt.Image;
import java.awt.Point;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;

public class MobileMock implements IMobile {

	private Point position;
	private ILevel level;
	private int lastX = 0;
	private int lastY = 0;
	
	public MobileMock(int x, int y) {
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
	

	@Override
	public int getX() {
		return this.getPosition().x;
	}
	
	public void setX(int x) {
		if (!this.isOnWall(x, this.getY())) {
			this.getPosition().x = x;
        }
	}

	@Override
	public int getY() {
		return this.getPosition().y;
	}
	
	public void setY(int y) {
		if (!this.isOnWall(this.getX(), y)) {
			this.getPosition().y = y;
        }
	}
	
	public void initX(int x) {
		this.getPosition().x = x;
	}
	
	public void initY(int y) {
		this.getPosition().y = y;
	}


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


	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}
	
	protected ILevel getLevel() {
		return this.level;
	}


}
