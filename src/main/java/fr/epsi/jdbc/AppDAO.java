package fr.epsi.jdbc;

import fr.epsi.jdbc.bo.User;
import fr.epsi.jdbc.dal.jdbc.UserDAO;

import java.sql.SQLException;

public class AppDAO {

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        try {
            dao.create( new User("sega", "ss@ss.org"));
            System.out.println( dao.readById(1) );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
