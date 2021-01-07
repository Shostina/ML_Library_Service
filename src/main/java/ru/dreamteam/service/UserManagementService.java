package ru.dreamteam.service;

import org.hibernate.SessionFactory;
import ru.dreamteam.db.dao.UserDAO;
import ru.dreamteam.db.tables.User;

import java.util.List;

public class UserManagementService {
    public static final SessionFactory SESSIONFACTORY = DBService.SESSIONFACTORY;

    public UserManagementService() { }

    public User auth(String name, String password) {
        User user = (new UserDAO(SESSIONFACTORY.openSession())).getUserByName(name).get(0);
        if (!user.getPassword().equals(password)) {
            return null;
        }
        //SESSIONFACTORY.getCurrentSession().close();
        return user;
    }

    public User addUser(String name, String password) {
        User user = (new UserDAO(SESSIONFACTORY.openSession())).addUser(name, password).get(0);
        //SESSIONFACTORY.getCurrentSession().close();
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = (new UserDAO(SESSIONFACTORY.openSession())).getAllUsers();
        //SESSIONFACTORY.getCurrentSession().close();
        return users;
    }
}
