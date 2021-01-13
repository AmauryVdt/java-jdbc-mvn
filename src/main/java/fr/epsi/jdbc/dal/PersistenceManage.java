package fr.epsi.jdbc.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class PersistenceManage {

    public static final String DB_URL;
    public static final String DB_USER_LOGIN;
    public static final String DB_USER_PASSWORD;

    private static Connection connection;

    static {
        // S'execute une fois
        System.out.println("PERSISTENCE INI STATIC BLOC");
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER_LOGIN = bundle.getString("db.user");
        DB_USER_PASSWORD = bundle.getString("db.pwd");
    }
    {
        // S'execute autant defois qu'il y a de new
        System.out.println("PERSISTENCE INI STATIC BLOC");
    }

    //private PersistenceManage() {}

    public static Connection getConnection() throws SQLException {
        if ( null == connection ) {
            connection = DriverManager.getConnection(DB_URL, DB_USER_LOGIN, DB_USER_PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if ( null != connection && !connection.isClosed()) {
            connection.close();
        }
     }

}
