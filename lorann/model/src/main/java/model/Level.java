package model;

import java.util.Observable;

public class Level extends Observable implements ILevel {
	
	private final int width = 20;
	private final int height = 12;
	
	private IElement[][] onTheLevel;
	
	public Level(int level) {
		super();
		this.loadLevel(level);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public IElement getOnTheLevelXY(int x, int y) {
		return onTheLevel[x][y];
	}
	
	@Override
	public void setOnTheLevelXY(int x, int y, IElement element) {
		this.onTheLevel[x][y] = element;
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	@Override
	public void setElementHasChanged() {
		this.setChanged();
		this.notifyObservers();

	}
	
	private void loadLevel(int level) {
		
	}

	@Override
	public boolean setSpellOnTheLevelXY(int x, int y, IElement spell) {
		if(this.getOnTheLevelXY(x, y).getPermeability() == Permeability.PENETRABLE) {
			this.onTheLevel[x][y] = spell;
			return true;
		}
		else {
			return false;
		}
	}

}