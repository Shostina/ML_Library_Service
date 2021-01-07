package ru.dreamteam.db.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter

@Entity
@Table(name = "book_tags")
public class BookTag implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;
    @Id
    @Column(name = "bookTagId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookTagId;

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private Book bookId;

    @Column(name = "tag")
    private String tag;

    public BookTag(){}
    @Override
    public String toString() {
        return ((Long)getBookTagId()).toString();
    }
}
