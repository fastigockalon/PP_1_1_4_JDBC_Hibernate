package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan","Petrov", (byte) 32);
        userService.saveUser("Petr","Ivanov", (byte) 28);
        userService.saveUser("Mariya","Sidorova", (byte) 23);
        userService.saveUser("Elena","Smirnova", (byte) 40);
        List<User> list1 = userService.getAllUsers();
        System.out.println(list1);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
