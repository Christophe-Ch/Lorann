package model;

import java.io.IOException;
import java.sql.SQLException;
import model.element.mobile.MyCharacter;
import model.element.mobile.collectible.Purse;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	private ILevel level;
	private IMobile character;
	private IMobile[] purses;
	private IMobile[] monsters;
	private IMobile energyBall;

    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     * @throws IOException 
     */
    public ModelFacade(int level) throws SQLException, IOException {
        super();
        this.setLevel(new Level(level));
        this.setCharacter(new MyCharacter((int)this.level.getCharacterPosition().getX(), (int)this.level.getCharacterPosition().getY(), this.level));

        purses = new IMobile[this.getLevel().getPurses().length];
        monsters = new IMobile[this.getLevel().getMonsters().length];
        
        for(int i = 0; i < purses.length; i++) {
        	purses[i] = new Purse((int)this.getLevel().getPurses()[i].getX(), (int)this.getLevel().getPurses()[i].getY(), this.level);
        }
        
        for(int i = 0; i < monsters.length; i++) {
        	
        }
    }
    
	@Override
	public ILevel getLevel() {
		return this.level;
	}

	@Override
	public IMobile getMyCharacter() {
		return this.character;
	}
	
	private void setLevel(ILevel level) {
		this.level = level;
	}

	private void setCharacter(IMobile character) {
		this.character = character;
	}

	public IMobile[] getPurses() {
		return purses;
	}

	public void setPurses(IMobile[] purses) {
		this.purses = purses;
	}

	public IMobile[] getMonsters() {
		return monsters;
	}

	public void setMonsters(IMobile[] monsters) {
		this.monsters = monsters;
	}

	@Override
	public IMobile getEnergyBall() {
		return this.energyBall;
	}
	
}
