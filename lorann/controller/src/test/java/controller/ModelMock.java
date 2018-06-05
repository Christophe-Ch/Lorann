
package controller;

import model.ILevel;
import model.IMobile;
import model.IModel;

/**
 * <h1>The Class ModelMock imitates the ModelFacade class.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public final class ModelMock implements IModel {
	
	private MobileMock character = new MobileMock(0, 0);

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#getLevel()
     */
	@Override
	public ILevel getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#getMyCharacter()
     */
	@Override
	public IMobile getMyCharacter() {
		return new MobileMock(0, 0);
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#getPurses()
     */
	@Override
	public IMobile[] getPurses() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#getMonsters()
     */
	@Override
	public IMobile[] getMonsters() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#getEnergyBall()
     */
	@Override
	public IMobile getEnergyBall() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#getDoor()
     */
	@Override
	public IMobile getDoor() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#getSpell()
     */
	@Override
	public IMobile getSpell() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     * @see contract.model.IModel#hasCharacterWon()
     */
	@Override
	public boolean hasCharacterWon() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
