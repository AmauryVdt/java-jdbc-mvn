package fr.epsi.jdbc.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

    private static DBConnection single;

    private Connection connection;

    private DBConnection() throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        Connection connection = DriverManager.getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle.getString( "db.pwd" ));
    }

    public static DBConnection getSingle() throws SQLException {
        if ( null == single ) {
            single = new DBConnection();
        }
        return single;
    }

    public Connection getConnection() {
        return connection;
    }
}
