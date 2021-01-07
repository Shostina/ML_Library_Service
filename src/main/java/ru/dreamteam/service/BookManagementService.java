package ru.dreamteam.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dreamteam.db.dao.BookDAO;
import ru.dreamteam.db.dao.BooksStatisticDAO;
import ru.dreamteam.db.tables.Book;
import ru.dreamteam.db.tables.BooksStatistic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookManagementService {
    public static final SessionFactory SESSIONFACTORY = DBService.SESSIONFACTORY;

    public List<Book> getSavedBooks(long userId) {
        List<BooksStatistic> booksStatistics = (new BooksStatisticDAO(SESSIONFACTORY.openSession())).getBooksByUserId(userId);
        List<Book> books = new ArrayList<>();
        for (BooksStatistic booksStatistic : booksStatistics) {
            System.out.println("!!! get saved book : " + booksStatistic.getBookId());
            books.add((new BookDAO(SESSIONFACTORY.openSession())).getBookById(booksStatistic.getBookId()).get(0));
  //          SESSIONFACTORY.getCurrentSession().close();
        }
        return books;
    }

    public List<Book> getMyBooks(long userId) {
        List<Book> books = (new BookDAO(SESSIONFACTORY.openSession())).getBookByAuthor(userId);
//        SESSIONFACTORY.getCurrentSession().close();
        return books;
    }

    public long addBook(String bookTitle, String author, long authorId, long dateTime, Set<String> genres,
                        Set<String> tags, String content) {
        long bookId = (new BookDAO(SESSIONFACTORY.openSession())).addBook(bookTitle, author, authorId, dateTime, genres, tags, content);
//        SESSIONFACTORY.getCurrentSession().close();
        return bookId;
    }

    public Book saveBook(long userId, long bookId) {
        Session session = SESSIONFACTORY.openSession();
        Book book = (new BookDAO(session)).likeBook(bookId);
        (new BooksStatisticDAO(session)).likeBook(userId, bookId);
        List<BooksStatistic> statistics = (new BooksStatisticDAO(session)).getBooksByUserId(userId);
        for (BooksStatistic b : statistics) {
            System.out.println("!!! save book: " + b.getBookId());
        }
 //       SESSIONFACTORY.getCurrentSession().close();
        return book;
    }
}
