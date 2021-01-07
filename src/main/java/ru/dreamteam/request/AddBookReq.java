package ru.dreamteam.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookReq {
    private String bookTitle;
    private String author;
    private long authorId;
    private long dateTime;
    Set<String> genres;
    Set<String> tags;
    private String content;
}
