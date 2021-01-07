package ru.dreamteam.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.dreamteam.db.tables.Book;

@Data
@AllArgsConstructor
public class SaveBookResp {
    Book book;
}
