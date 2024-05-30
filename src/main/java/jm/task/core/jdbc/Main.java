package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import static jm.task.core.jdbc.util.Util.closeSession;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Tanya", "Politova", (byte) 22);
        userService.saveUser("Aleks", "Petrov", (byte) 43);
        userService.saveUser("Irina", "Ivanova", (byte) 7);
        userService.saveUser("Olya", "Babushkina", (byte) 82);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        closeSession();
    }
}