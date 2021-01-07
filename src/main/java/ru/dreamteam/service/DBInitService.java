package ru.dreamteam.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dreamteam.db.tables.User;

public class DBInitService {
    public static final SessionFactory SESSIONFACTORY = DBService.SESSIONFACTORY;

    public static void main(String[] args) {
        new DBInitService().initEntry();
    }

    public void initEntry() {
        Session session = SESSIONFACTORY.openSession();
        User admin = new User();
        admin.setName("Admin");
        admin.setPassword("password");
        session.save(admin);
        User admin1 = new User();
        admin1.setName("Admin1");
        admin1.setPassword("password1");
        session.save(admin1);
    }
}
