package fr.epsi.jdbc;

import fr.epsi.jdbc.entities.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {

    private static void displaySuppliers() {
        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection =DriverManager
                .getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle
                        .getString( "db.pwd" ));
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery( "SELECT * FROM fournisseur" )
        ) {
            ResultSetMetaData rsm = rs.getMetaData();

            int nbColumns = rsm.getColumnCount();
            for(int i = 1; i <= nbColumns; ++i) {
                System.out.printf( "%30s (%s)", rsm.getColumnName( i ), rsm.getColumnTypeName( i ) );
            }
            System.out.println();
            List<Fournisseur> supplierList = new ArrayList<>();
            while(rs.next()) {
                for ( int i = 1; i <= nbColumns; ++i ) {
                    System.out.printf( "%30s", rs.getString( i ) );
                }
                supplierList.add(new Fournisseur(rs.getString("ID"), rs.getString("NOM")));
                System.out.println();
            }
            for (Fournisseur supplier : supplierList) {
                System.out.println(supplier.ID + supplier.NOM);
            }

        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        displaySuppliers();
    }
}
