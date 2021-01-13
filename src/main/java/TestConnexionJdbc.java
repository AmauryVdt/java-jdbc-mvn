import resources.MyResource;

import java.sql.*;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

//    private static final String DB_URL = "jdbc:mariadb://localhost:3406/compta";
//    private static final String DB_USER = "root";
//    private static final String DB_PWD = "root";

    private static void createUserWithResources() {
        //Class.forName( bundle.getString( "db.url" ) );
        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection = DriverManager.getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle.getString( "db.pwd" ));
             Statement st = connection.createStatement()) {
            int nb = st.executeUpdate( "INSERT INTO user (name, email) VALUES ('SSY','ssy@ssy.org')" );
            System.out.println(nb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void  displayUser() {
        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection = DriverManager.getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle.getString( "db.pwd" ));
             Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery( "SELECT * FROM USER" )
        ) {
            ResultSetMetaData rsm = rs.getMetaData();

            int nbColumns = rsm.getColumnCount();
            for (int i = 1; i <= nbColumns; ++i) {
                System.out.printf("%30s", rsm.getColumnName(i), rsm.getColumnName(i));
            }
            System.out.println();
            while (rs.next()) {
//                System.out.printf("%-10d|%-20s|%-20s\n", rs.getInt(1), rs.getString("name"), rs.getString(3));
                for (int i = 1; i <= nbColumns; ++i) {
                    System.out.printf("30%s", rs.getString(i));
                }
            }

        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        createUserWithResources();
        displayUser();
    }
}
