package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users(id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, " +
                "lastName VARCHAR(255) NOT NULL, age INT NOT NULL, PRIMARY KEY(id))";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            int res = statement.executeUpdate(query);
//            System.out.println(res + " Table created");
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            int res = statement.executeUpdate(query);
//            System.out.println(res + " Table deleted");
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            int res = preparedStatement.executeUpdate();
//            System.out.println(res + " User added");
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void removeUserById(long id) {
        String query = "DELETE FROM users WHERE id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            int res = preparedStatement.executeUpdate();
//            System.out.println(res +" User removed");
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        String query = "SELECT * FROM users";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"), resultSet.getString("lastName"), (byte) resultSet.getInt("age"));
                user.setId(resultSet.getLong("id"));
                result.add(user);
            }
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return result;
    }

    public void cleanUsersTable() {
        String query = "DELETE FROM users";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            int res = statement.executeUpdate(query);
//            System.out.println(res + " Users deleted");
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
