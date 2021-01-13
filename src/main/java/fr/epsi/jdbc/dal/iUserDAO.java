package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.bo.User;

import java.sql.SQLException;
import java.util.List;

public interface iUserDAO {

    void create(User user) throws SQLException;
    User readById(int id) throws SQLException;
    List<User> readAll();
    void delete(User user);
    void update(User user);
}
