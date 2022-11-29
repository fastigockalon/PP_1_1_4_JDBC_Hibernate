package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao jdbcDAO = new UserDaoJDBCImpl();
    private final UserDao hibernateDAO = new UserDaoHibernateImpl();
    public void createUsersTable() {
        hibernateDAO.createUsersTable();
//        jdbcDAO.createUsersTable();
    }

    public void dropUsersTable() {
        hibernateDAO.dropUsersTable();
//        jdbcDAO.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        hibernateDAO.saveUser(name, lastName, age);
//        jdbcDAO.saveUser(name, lastName, age);
        System.out.println("User c именем - " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        hibernateDAO.removeUserById(id);
//        jdbcDAO.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return hibernateDAO.getAllUsers();
//        return jdbcDAO.getAllUsers();
    }

    public void cleanUsersTable() {
        hibernateDAO.cleanUsersTable();
//        jdbcDAO.cleanUsersTable();
    }
}
