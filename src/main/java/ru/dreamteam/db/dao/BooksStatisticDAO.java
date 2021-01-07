package ru.dreamteam.db.dao;

import ru.dreamteam.db.tables.Book;
import ru.dreamteam.db.tables.BooksStatistic;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BooksStatisticDAO {
    private final Session session;

    public BooksStatisticDAO(Session session) {
        this.session = session;
    }

    public BooksStatistic get(long id) throws HibernateException {
        return (BooksStatistic) session.get(BooksStatistic.class, id);
    }

    public List<BooksStatistic> getBooksStatisticById(long id) throws HibernateException {
        Criteria criteria = session.createCriteria(BooksStatistic.class);
        return criteria.add(Restrictions.eq("bookStatisticId", id)).list();
    }

    public List<BooksStatistic> getBooksByUserId(long id) throws HibernateException {
        Criteria criteria = session.createCriteria(BooksStatistic.class);
        return criteria.add(Restrictions.eq("userId", id)).list();
    }

    public List<BooksStatistic> getUsersByBookId(long id) throws HibernateException {
        Criteria criteria = session.createCriteria(BooksStatistic.class);
        return criteria.add(Restrictions.eq("bookId", id)).list();
    }
    public void likeBook(long userId, long bookId) throws HibernateException {
        BooksStatistic booksStatistic = new BooksStatistic();
        booksStatistic.setUserId(userId);
        booksStatistic.setBookId(bookId);
        session.save(booksStatistic);
    }
}
