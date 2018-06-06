package model;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.dao.LorannDAO;
import model.element.mobile.auto.FirstMonster;
import model.element.mobile.auto.FourthMonster;
import model.element.mobile.auto.SecondMonster;
import model.element.mobile.auto.Spell;
import model.element.mobile.auto.ThirdMonster;
import model.element.mobile.collectible.Door;
import model.element.mobile.collectible.EnergyBall;
import model.element.mobile.collectible.Purse;
import model.element.motionless.MotionlessElementFactory;

/**
 * <h1>The Level class</h1>
 * 
 * @author Christophe CHICHMANIAN
 * @version 1.0
 */
public class Level extends Observable implements ILevel {
	
	/** Constant width of the map */
	private final int width = 20;
	
	/** Constant height of the map */
	private final int height = 12;
	
	/** Array which contains all the elements of the level */
	private IElement[][] onTheLevel;
	
	/** Position of the character */
	private Point characterPosition;
	
	/** List of all purses */
	private ArrayList<IMobile> purses;
	
	/** List of all monsters */
	private ArrayList<IMobile> monsters;
	
	/** The key */
	private IMobile energyBall;
	
	/** The door */
	private IMobile door;
	
	/** The spell */
	private IMobile spell;
	
	/** 
	 * Instantiates a new Level object
	 * 
	 * @param level
	 * 		The number of the level (ID field of the database)
	 */
	public Level(int level) {
		super();
		purses = new ArrayList<>();
		monsters = new ArrayList<>();
		
		try {
			this.loadLevel(level);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
     * Gets the width.
     */
	@Override
	public int getWidth() {
		return this.width;
	}

	/**
     * Gets the height.
     */
	@Override
	public int getHeight() {
		return this.height;
	}

	/**
	 * Gets an element on the road
	 * 
	 * @param x
	 * 		X coordinate
	 * 
	 * @param y
	 * 		Y coordinate
	 */
	@Override
	public IElement getOnTheLevelXY(int x, int y) {
		return onTheLevel[x][y];
	}
	
	/**
	 * Puts an element on the road
	 * @param x
	 * 		X coordinate
	 * @param y
	 * 		Y coordinate
	 * @param element
	 * 		Element to put on the level
	 */
	@Override
	public void setOnTheLevelXY(int x, int y, IElement element) {
		this.onTheLevel[x][y] = element;
	}

	/**
	 * Gets the observable object (this)
	*/
	@Override
	public Observable getObservable() {
		return this;
	}

	/**
	 * Notifies observers an element has changed
	 */
	@Override
	public void setElementHasChanged() {
		this.setChanged();
		this.notifyObservers();

	}
	
	/**
	 * Loads the level from the database.
	 * @param level
	 * 		ID of the level into the database
	 * @throws SQLException
	 * 		if the query fails
	 * @throws IOException
	 * 		if the image of a sprite doesn't exist
	 */
	private void loadLevel(int level) throws SQLException, IOException {
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
						this.purses.add(new Purse(x, y, this));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'B':
						this.energyBall = new EnergyBall(x, y, this);
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'S':
						this.door = new Door(x, y, this);
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'M':
						this.monsters.add(new FirstMonster(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'N':
						this.monsters.add(new SecondMonster(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'O' :
						this.monsters.add(new ThirdMonster(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'P':
						this.monsters.add(new FourthMonster(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					default: 
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.getFromFileSymbol(levelArray[y].toCharArray()[x]));
						break;
				}
			}
		}
		
		this.spell = new Spell(this, 0, 0, this.getOnTheLevelXY(0, 0).getSprite());
		
	}
	
	/**
	 * Gets the position of the character on the level
	 */
	public Point getCharacterPosition() {
		return this.characterPosition;
	}
	
	/**
	 * Sets the position of the character on the level
	 * 
	 * @param position
	 * 		position of the character
	 */
	private void setCharacterPosition(Point position) {
		this.characterPosition = position;
	}
	
	/**
	 * Gets the list of all purses
	 */
	public IMobile[] getPurses() {
		IMobile[] result = new IMobile[this.purses.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = purses.get(i);
		}
		return result;
	}
	
	/**
	 * Gets the list of all monsters
	 */
	public IMobile[] getMonsters() {
		IMobile[] result = new IMobile[this.monsters.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = monsters.get(i);
		}
		return result;
	}
	
	/**
	 * Gets the energy ball
	 */
	public IMobile getEnergyBall() {
		return energyBall;
	}
	
	/**
	 * Gets the door
	 */
	public IMobile getDoor() {
		return door;
	}
	
	/**
	 * Gets the spell
	 */
	public IMobile getSpell() {
		return spell;
	}
	
	

}
