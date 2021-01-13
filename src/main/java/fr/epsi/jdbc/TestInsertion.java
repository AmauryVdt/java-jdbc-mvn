package fr.epsi.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TestInsertion {

    private static void insertSupplier() {
        //Class.forName( bundle.getString( "db.url" ) );
        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection = DriverManager.getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle.getString( "db.pwd" ));
             Statement st = connection.createStatement()) {
            int nb = st.executeUpdate( "INSERT INTO fournisseur (NOM) VALUES ( 'La Maison de la Peinture')" );
            System.out.println(nb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertSupplier();
    }
}
