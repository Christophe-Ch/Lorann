package test;

import java.awt.Image;
import java.awt.Point;

import javax.swing.text.DefaultStyledDocument.ElementBuffer;

import model.IMobile;
import model.Permeability;
import model.Sprite;

public class MobileMock implements IMobile {

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
	public boolean moveUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHit(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

<<<<<<< HEAD
	public boolean isOnDoor(int newX, int newY) {
=======
	@Override
	public Point getPosition() {
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	public boolean isOnKey(int newX, int newY) {
=======
	@Override
	public void shoot(int direction) {
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return false;
	}

	public boolean isOnWall(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isOnPurse(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
=======
		
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
