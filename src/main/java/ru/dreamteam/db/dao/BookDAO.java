package ru.dreamteam.db.dao;

import ru.dreamteam.db.tables.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDAO {
    private final Session session;

    public BookDAO(Session session) {
        this.session = session;
    }

    public Book get(long id) throws HibernateException {
        return (Book) session.get(Book.class, id);
    }

    public List<Book> getBookById(long id) throws HibernateException {
        Criteria criteria = session.createCriteria(Book.class);
        return criteria.add(Restrictions.eq("bookId", id)).list();
    }

    public List<Book> getBookByTitle(String title) throws HibernateException {
        Criteria criteria = session.createCriteria(Book.class);
        return criteria.add(Restrictions.eq("bookTitle", title)).list();
    }

    public List<Book> getBookByAuthor(long authorId) throws HibernateException {
        Criteria criteria = session.createCriteria(Book.class);
        return criteria.add(Restrictions.eq("authorId", authorId)).list();
    }

    public long addBook(String bookTitle, String author, long authorId, long dateTime, Set<String>genres,
                        Set<String> tags, String content) {
        Book book = new Book();
        book.setBookTitle(bookTitle);
        book.setAuthor(author);
        book.setAuthorId(authorId);
        book.setDateTime(dateTime);
        Set<BookTag> bookTags = new HashSet<>();
        for (String tag : tags) {
            BookTag bookTag = new BookTag();
            bookTag.setBookId(book);
            bookTag.setTag(tag);
            session.save(bookTag);
            bookTags.add(bookTag);
        }
        book.setTags(bookTags);
        Set<BookGenre> bookGenres = new HashSet<>();
        for (String genre : genres) {
            BookGenre bookGenre = new BookGenre();
            bookGenre.setBookId(book);
            bookGenre.setGenre(genre);
            session.save(bookGenre);
            bookGenres.add(bookGenre);
        }
        book.setGenres(bookGenres);
        book.setContent(content);
        session.save(book);
        return getBookByTitle(book.getBookTitle()).get(0).getBookId();
    }

    public Book likeBook(long bookId) throws HibernateException {
        Book book = getBookById(bookId).get(0);
        book.setNumOfLikes(book.getNumOfLikes() + 1);
        session.update(book);
        return getBookById(bookId).get(0);
    }
}
