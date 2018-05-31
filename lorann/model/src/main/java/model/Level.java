package model;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.dao.LorannDAO;
import model.element.motionless.MotionlessElementFactory;

public class Level extends Observable implements ILevel {
	
	private final int width = 20;
	private final int height = 12;
	
	private IElement[][] onTheLevel;
	
	private Point characterPosition;
	
	private ArrayList<Point> pursesPositions;
	
	private ArrayList<Point> monstersPositions;
	
	private Point energyBall;
	
	public Level(int level) throws SQLException {
		super();
		pursesPositions = new ArrayList<>();
		monstersPositions = new ArrayList<>();
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
	
	private void loadLevel(int level) throws SQLException {
		String levelText = LorannDAO.chooseLevel(level);
		this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
		String[] levelArray = levelText.split(",");
		
		for(int y = 0; y < 12; y++) {
			for(int x = 0; x < 20; x++) {
				switch(levelArray[y].toCharArray()[x]) {
					case 'L':
						this.setCharacterPosition(new Point(x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'A':
						this.pursesPositions.add(new Point(x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'B':
						this.energyBall = new Point(x, y);
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
					default: 
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.getFromFileSymbol(levelArray[y].toCharArray()[x]));
						break;
				}
			}
		}
		
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
	
	public Point getCharacterPosition() {
		return this.characterPosition;
	}
	
	private void setCharacterPosition(Point position) {
		this.characterPosition = position;
	}
	
	public Point[] getPurses() {
		Point[] result = new Point[this.pursesPositions.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = pursesPositions.get(i);
		}
		return result;
	}
	
	public Point[] getMonsters() {
		Point[] result = new Point[this.monstersPositions.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = monstersPositions.get(i);
		}
		return result;
	}
	
	public Point getEnergyBall() {
		return energyBall;
	}
	
	

}
