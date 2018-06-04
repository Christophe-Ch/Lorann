
package test;

import java.awt.Point;
import java.util.Observable;

import model.IElement;
import model.ILevel;
import model.IMobile;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard & Christophe Chichmanian & Charlotte Bénard & François Mouton
 * @version 1.0
 */
public class LevelMock implements ILevel{
	
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public IElement getOnTheLevelXY(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void setOnTheLevelXY(int x, int y, IElement element) {
		// TODO Auto-generated method stub
		
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public boolean setSpellOnTheLevelXY(int x, int y, IElement spell) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void setElementHasChanged() {
		// TODO Auto-generated method stub
		
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public Point getCharacterPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public IMobile[] getPurses() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public IMobile[] getMonsters() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public IMobile getEnergyBall() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public IMobile getDoor() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public IMobile getSpell() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
