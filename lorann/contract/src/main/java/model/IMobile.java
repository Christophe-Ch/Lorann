package model;

import java.awt.Point;

public interface IMobile extends IElement{
	
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
	

}
