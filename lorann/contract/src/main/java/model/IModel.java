package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    /**
     * Choose the level.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    ILevel chooseLevel(int id) throws SQLException;
    
    ILevel getLevel();
    
    IMobile getMyCharacter();
}
