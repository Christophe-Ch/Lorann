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
 * @author Corentin Hangard
 * @version 1.0
 */
public class MobileMock implements IMobile {

	/*
     * Override method.
     * 
     */
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public boolean moveUp() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
     * Override method.
     * 
     */
	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	/*
     * Override method.
     * 
     */
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public boolean isHit(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * Override method.
     * 
     */
	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	/*
     * Override method.
     * 
     */
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
