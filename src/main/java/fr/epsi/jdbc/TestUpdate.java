package fr.epsi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

    private static void updateSupplier() {
        //Class.forName( bundle.getString( "db.url" ) );
        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection = DriverManager.getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle.getString( "db.pwd" ));
             Statement st = connection.createStatement()) {
            int nb = st.executeUpdate( "UPDATE fournisseur SET NOM = 'La Maison des Peintures' WHERE NOM = 'La Maison de la Peinture'" );
            System.out.println(nb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateSupplier();
    }
}
