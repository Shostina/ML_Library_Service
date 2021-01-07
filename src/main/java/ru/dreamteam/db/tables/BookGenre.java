package ru.dreamteam.db.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter

@Entity
@Table(name = "book_genres")
public class BookGenre implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;
    @Id
    @Column(name = "bookGenreId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookGenreId;

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private Book bookId;

    @Column(name = "genre")
    private String genre;

    public BookGenre(){}

    @Override
    public String toString() {
        return ((Long)getBookGenreId()).toString();
    }
}
