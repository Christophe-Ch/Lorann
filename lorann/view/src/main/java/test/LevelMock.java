package test;

import java.util.Observable;

import model.IElement;
import model.ILevel;

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
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElementHasChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IElement setOnTheLevelXY(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}