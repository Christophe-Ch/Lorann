package model;

import java.awt.Point;

import showboard.IPawn;

public interface IMobile extends IElement, IPawn{
	
	void moveUp();
	void moveLeft();
	void moveDown();
	void moveRight();
	void doNothing();
	int getX();
	int getY();
	boolean isAlive();
	boolean isHit();
	boolean isOnDoor();
	boolean isOnKey();
	Point getPosition();
	void shoot();
	

}
