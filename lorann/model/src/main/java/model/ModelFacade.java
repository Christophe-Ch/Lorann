package model;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import model.element.mobile.MyCharacter;

/**
 * <h1>The ModelFacade class provides a facade of the Model component.</h1>
 *
 * @author Christophe CHICHMANIAN
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	/** The level */
	private ILevel level;
	
	/** The character */
	private MyCharacter character;
	
	/** The list of all purses */
	private IMobile[] purses;
	
	/** The list of all monsters */
	private IMobile[] monsters;
	
	/** The key */
	private IMobile energyBall;
	
	/** The door */
	private IMobile door;
	
	/** The spell */
	private IMobile spell;
	
    /**
     * Instantiates a new model facade.
     * 
     * @param level
     * 		ID of the level into the database
     * 
     * @throws SQLException
     * 		if the sql query fails
     * 
     * @throws IOException
     * 		if the image of a sprite doesn't exist
     */
    public ModelFacade(int level) throws SQLException, IOException {
        this.setLevel(new Level(level));
        this.setCharacter(new MyCharacter(
        		(int)this.level.getCharacterPosition().getX(), 
        		(int)this.level.getCharacterPosition().getY(), 
        		this.level));

        purses = new IMobile[this.getLevel().getPurses().length];
        monsters = new IMobile[this.getLevel().getMonsters().length];
        
        for(int i = 0; i < purses.length; i++) {
        	purses[i] = this.getLevel().getPurses()[i];
        	this.getMyCharacter().addPurse(purses[i]);
        }
        
        for(int i = 0; i < monsters.length; i++) {
        	monsters[i] = this.getLevel().getMonsters()[i];
	        this.getMyCharacter().addMonster(monsters[i]);
        }
        
        energyBall = this.getLevel().getEnergyBall();
        this.getMyCharacter().addEnergyBall(energyBall);
        
        door = this.getLevel().getDoor();
        this.getMyCharacter().addDoor(door);
        
        spell = this.getLevel().getSpell();
        this.getMyCharacter().addSpell(spell);
    }
    
    /**
     * Gets the level
     */
	@Override
	public ILevel getLevel() {
		return this.level;
	}

	/**
	 * Gets the character
	 */
	@Override
	public MyCharacter getMyCharacter() {
		return this.character;
	}
	
	/**
	 * Sets the level
	 * @param level
	 * 		The level
	 */
	private void setLevel(ILevel level) {
		this.level = level;
	}

	/**
	 * Sets the character
	 * @param character
	 * 		The character
	 */
	private void setCharacter(MyCharacter character) {
		this.character = character;
	}

	/**
	 * Gets the list of all purses
	 */
	public IMobile[] getPurses() {
		return purses;
	}

	/**
	 * Sets the list of all purses
	 * @param purses
	 * 		List of all purses
	 */
	public void setPurses(IMobile[] purses) {
		this.purses = purses;
	}

	/**
	 * Gets the list of all monsters
	 */
	public IMobile[] getMonsters() {
		return monsters;
	}

	/**
	 * Sets the list of all monsters
	 * @param monsters
	 * 		List of all monsters
	 */
	public void setMonsters(IMobile[] monsters) {
		this.monsters = monsters;
	}

	/**
	 * Gets the key
	 */
	public IMobile getEnergyBall() {
		return this.energyBall;
	}
	
	/**
	 * Gets the door
	 */
	public IMobile getDoor() {
		return this.door;
	}

	/**
	 * Gets the value of the attribute 'won' of the character
	 */
	@Override
	public boolean hasCharacterWon() {
		return ((MyCharacter)this.getMyCharacter()).hasWon();
	}

	/**
	 * Gets the spell
	 */
	@Override
	public IMobile getSpell() {
		return this.spell;
	}
	
}
