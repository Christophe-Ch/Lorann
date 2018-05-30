package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Level;

public abstract class LorannDAO extends AbstractDAO{

	/** The sql example by id. */
    private static String sqlChooseLevel = "{call ChooseLevel(?)}";
    
    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static Level chooseLevel(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlChooseLevel);
        Level level = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                level = new Level(id);
            }
            result.close();
        }
        return level;
    }
}
