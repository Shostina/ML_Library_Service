package ru.dreamteam.db.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter

@Entity
@Table(name = "Books_Statistic")
public class BooksStatistic implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;
    @Id
    @Column(name = "bookStatisticId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookStatisticId;

    @Column(name = "bookId")
    private long bookId;

    @Column(name = "userId")
    private long userId;

    public BooksStatistic() {
    }
    @Override
    public String toString() {
        return ((Long)getBookStatisticId()).toString();
    }
}
