package test;

import java.awt.Image;
import java.awt.Point;

import javax.swing.text.DefaultStyledDocument.ElementBuffer;

import model.IMobile;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard & Christophe Chichmanian & Charlotte Bénard & François Mouton
 * @version 1.0
 */
public class MobileMock implements IMobile {

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public boolean moveUp() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public boolean isHit(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

<<<<<<< HEAD
<<<<<<< HEAD
	public boolean isOnDoor(int newX, int newY) {
=======
=======
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
	@Override
	public Point getPosition() {
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
<<<<<<< HEAD
	public boolean isOnKey(int newX, int newY) {
=======
=======
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
>>>>>>> branch 'master' of https://github.com/ChriisX/Lorann
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

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
