package model;

import java.awt.Point;

import showboard.IPawn;

public interface IMobile extends IElement, IPawn{
	
	boolean moveUp();
	boolean moveLeft();
	boolean moveDown();
	boolean moveRight();
	boolean moveUpperRight();
	boolean moveUpperLeft();
	boolean moveBottomRight();
	boolean moveBottomLeft();
	void doNothing();
	int getX();
	int getY();
	boolean isAlive();
	boolean isHit(int newX, int newY);
	Point getPosition();
	void shoot();
	int collect();
	void move();

}
