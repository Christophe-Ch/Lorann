package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;
import model.dao.LorannDAO;

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
     */
    public ModelFacade(int level) {
        super();
    }
    
    @Override
	public Level chooseLevel(int id) throws SQLException {
		return LorannDAO.chooseLevel(id);
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
