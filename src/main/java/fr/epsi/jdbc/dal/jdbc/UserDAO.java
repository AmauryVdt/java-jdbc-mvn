package fr.epsi.jdbc.dal.jdbc;

import fr.epsi.jdbc.bo.User;
import fr.epsi.jdbc.dal.DBConnection;
import fr.epsi.jdbc.dal.PersistenceManage;
import fr.epsi.jdbc.dal.iUserDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO implements iUserDAO {

    @Override
    public void create(User user) throws SQLException {
        Connection connection = PersistenceManage.getConnection();
        try (Statement st = connection.createStatement() ) {
            st.executeUpdate("INSERT INTO user (name, email) VALUES ('"+user.getName()+"','"+user.getEmail()+"')");
        }
    }

    @Override
    public User readById(int id) throws SQLException {
        //Connection connection = DBConnection.getSingle().getConnection();
        User user = null;
        Connection connection = PersistenceManage.getConnection();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM user WHERE id = " + id)) {
            if (rs.next()) {
                user = new User( rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        }
        return user;
    }

    @Override
    public List<User> readAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }
}
