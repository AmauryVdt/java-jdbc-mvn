package fr.epsi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

    private static void deleteSupplier() {
        //Class.forName( bundle.getString( "db.url" ) );
        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection = DriverManager.getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle.getString( "db.pwd" ));
             Statement st = connection.createStatement()) {
            int nb = st.executeUpdate( "DELETE FROM fournisseur WHERE NOM = 'La Maison des Peintures'" );
            System.out.println(nb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        deleteSupplier();
    }
}
