package view;

import java.awt.Point;

import model.IMobile;


/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard
 * @version 1.0
 */
public abstract class MobileMock extends ElementMock implements IMobile {

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

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
