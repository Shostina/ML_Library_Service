package ru.dreamteam.db.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "books")
public class Book implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;
    @Id
    @Column(name = "bookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @Column(name = "bookTitle")
    private String bookTitle;

    @Column(name = "author")
    private String author;

    @Column(name = "authorId", nullable = false)
    private long authorId;

    @Column(name = "DateTime")
    private long dateTime;

    @OneToMany(mappedBy="bookId")
    Set<BookGenre> genres;

    @OneToMany(mappedBy="bookId")
    Set<BookTag> tags;

    @Column(name = "content")
    private String content;

    @Column(name = "numOfLikes")
    private long numOfLikes;

    public Book(){}

    @Override
    public String toString() {
        return ((Long)getBookId()).toString();
    }
}
