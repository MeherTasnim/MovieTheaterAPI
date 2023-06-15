package com.mehertasnim.Movie.Theater.API.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public List<Show> getWatchedShows() {
        return watchedShows;
    }

    public void setWatchedShows(List<Show> watchedShows) {
        this.watchedShows = watchedShows;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_user_id")
    private List<Show> watchedShows;
}
