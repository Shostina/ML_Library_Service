package ru.dreamteam.db.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "books")
    @OneToMany(mappedBy = "")
    private Set<Book> books;

    public User(){}

    @Override
    public String toString() {
        return ((Long)getUserId()).toString();
    }
}
