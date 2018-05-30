package test;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.ILevel;
import model.IMobile;
import model.IModel;

public final class ModelMock implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelMock() {
        super();
    }

	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllExamples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILevel getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMobile getMyCharacter() {
		// TODO Auto-generated method stub
		return null;
	}
}