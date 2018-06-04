package model;

import java.io.IOException;
import java.sql.SQLException;
import model.element.mobile.MyCharacter;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	private ILevel level;
	private MyCharacter character;
	private IMobile[] purses;
	private IMobile[] monsters;
	private IMobile energyBall;
	private IMobile door;
	private IMobile spell;
	
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
        	purses[i] = this.getLevel().getPurses()[i];
        	this.getMyCharacter().addPurse(purses[i]);
        }
        
        for(int i = 0; i < monsters.length; i++) {
        	monsters[i] = this.getLevel().getMonsters()[i];
	        this.getMyCharacter().addMonster(monsters[i]);
        }
        
        energyBall = this.getLevel().getEnergyBall();
        ((MyCharacter)this.getMyCharacter()).addEnergyBall(energyBall);
        
        door = this.getLevel().getDoor();
        ((MyCharacter)this.getMyCharacter()).addDoor(door);
        
        spell = this.getLevel().getSpell();
        ((MyCharacter)this.getMyCharacter()).addSpell(spell);
    }
    
	@Override
	public ILevel getLevel() {
		return this.level;
	}

	@Override
	public MyCharacter getMyCharacter() {
		return this.character;
	}
	
	private void setLevel(ILevel level) {
		this.level = level;
	}

	private void setCharacter(MyCharacter character) {
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

	public IMobile getEnergyBall() {
		return this.energyBall;
	}
	
	public IMobile getDoor() {
		return this.door;
	}

	@Override
	public boolean hasCharacterWon() {
		return ((MyCharacter)this.getMyCharacter()).hasWon();
	}

	@Override
	public IMobile getSpell() {
		return this.spell;
	}
	
}
