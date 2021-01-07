package ru.dreamteam.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.dreamteam.db.tables.Book;
import ru.dreamteam.request.AddBookReq;
import ru.dreamteam.request.GetBooksReq;
import ru.dreamteam.request.SaveBookReq;
import ru.dreamteam.response.AddBookResp;
import ru.dreamteam.response.GetBooksResp;
import ru.dreamteam.response.SaveBookResp;
import ru.dreamteam.service.BookManagementService;

import java.util.List;

@RestController
public class BookController {
    BookManagementService bookManagementService = new BookManagementService();
    @RequestMapping(value = "/add_book", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AddBookResp addBook(@RequestBody AddBookReq req) {
        long bookId = bookManagementService.addBook(req.getBookTitle(), req.getAuthor(), req.getAuthorId(), req.getDateTime(), req.getGenres(),
                req.getTags(), req.getContent());
        return new AddBookResp(bookId);
    }

    @RequestMapping(value = "/get_saved_books", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GetBooksResp getSavedBooks(@RequestBody GetBooksReq req) {
        List<Book> books = bookManagementService.getSavedBooks(req.getUserId());
        return new GetBooksResp(books);
    }

    @RequestMapping(value = "/get_my_books", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GetBooksResp getMyBooks(@RequestBody GetBooksReq req) {
        List<Book> books = bookManagementService.getMyBooks(req.getUserId());
        return new GetBooksResp(books);
    }

    @RequestMapping(value = "/save_book", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaveBookResp saveBook(@RequestBody SaveBookReq req) {
        Book book = bookManagementService.saveBook(req.getUserId(), req.getBookId());
        return new SaveBookResp(book);
    }
}
