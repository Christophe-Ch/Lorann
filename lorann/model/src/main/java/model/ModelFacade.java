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
	private IMobile character;

    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     * @throws IOException 
     */
    public ModelFacade(int level) throws SQLException, IOException {
        super();
        this.setLevel(new Level(level));
        this.setCharacter(new MyCharacter((int)this.level.getCharacterPosition().getX(), (int)this.level.getCharacterPosition().getY(), this.level));
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
	
}
