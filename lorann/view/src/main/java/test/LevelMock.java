
package test;

import java.awt.Point;
import java.util.Observable;

import model.IElement;
import model.ILevel;
import model.IMobile;

public class LevelMock implements ILevel{

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IElement getOnTheLevelXY(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOnTheLevelXY(int x, int y, IElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setSpellOnTheLevelXY(int x, int y, IElement spell) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElementHasChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getCharacterPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMobile[] getPurses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMobile[] getMonsters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMobile getEnergyBall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMobile getDoor() {
		// TODO Auto-generated method stub
		return null;
	}
	
}