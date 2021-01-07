package ru.dreamteam.db.dao;

import ru.dreamteam.db.tables.Book;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.dreamteam.db.tables.User;

import java.util.List;

public class UserDAO {
    private final Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public User get(long id) throws HibernateException {
        return (User) session.get(User.class, id);
    }

    public List<User> getUserByName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(User.class);
        return criteria.add(Restrictions.eq("name", name)).list();
    }
    public List<User>getAllUsers() throws HibernateException {
        return session.createCriteria(User.class).list();
    }

    public List<User> addUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        session.save(user);
        return getUserByName(name);

    }
}
