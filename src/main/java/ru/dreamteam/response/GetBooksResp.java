package ru.dreamteam.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.dreamteam.db.tables.Book;
import java.util.List;

@Data
@AllArgsConstructor
public class GetBooksResp {
    List<Book> books;
}
