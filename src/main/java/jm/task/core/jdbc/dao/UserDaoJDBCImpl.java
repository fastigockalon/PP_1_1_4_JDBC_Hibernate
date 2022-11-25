package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users(id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, " +
                "lastName VARCHAR(255) NOT NULL, age INT NOT NULL, PRIMARY KEY(id))";
        try(Statement statement = Util.getConnection().createStatement()) {
            int res = statement.executeUpdate(query);
//            System.out.println(res + " Table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users";
        try(Statement statement = Util.getConnection().createStatement()) {
            int res = statement.executeUpdate(query);
//            System.out.println(res + " Table deleted");
        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try(PreparedStatement preparedStatement = Util.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            int res = preparedStatement.executeUpdate();
//            System.out.println(res + " User added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String query = "DELETE FROM users WHERE id=?";
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(query)){
            preparedStatement.setLong(1, id);
            int res = preparedStatement.executeUpdate();
//            System.out.println(res +" User removed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        String query = "SELECT * FROM users";
        try(Statement statement = Util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"), resultSet.getString("lastName"), (byte) resultSet.getInt("age"));
                user.setId(resultSet.getLong("id"));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void cleanUsersTable() {
        String query = "DELETE FROM users";
        try(Statement statement = Util.getConnection().createStatement()) {
            int res = statement.executeUpdate(query);
//            System.out.println(res + " Users deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
