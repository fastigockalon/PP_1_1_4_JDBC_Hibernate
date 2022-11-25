package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDaoJDBCImpl jdbcDAO = new UserDaoJDBCImpl();
    public void createUsersTable() {
        jdbcDAO.createUsersTable();
    }

    public void dropUsersTable() {
        jdbcDAO.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        jdbcDAO.saveUser(name, lastName, age);
        System.out.println("User c именем - " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        jdbcDAO.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return jdbcDAO.getAllUsers();
    }

    public void cleanUsersTable() {
        jdbcDAO.cleanUsersTable();
    }
}
