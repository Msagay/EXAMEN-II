//Refactorización
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Infrastructure.smAppConfig;

public abstract class smSQLiteDataHelper {
    
    protected static Connection smGetConnection() throws SQLException {
        try {
            Class.forName(smAppConfig.smDRIVER);
            return DriverManager.getConnection(smAppConfig.smDB_URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found", e);
        }
    }
}
