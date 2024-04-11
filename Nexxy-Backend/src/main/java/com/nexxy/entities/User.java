package com.nexxy.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class User {
    @GeneratedValue
    @Id
    private Long id;
    private String username;
    private String email;
    private String password;

    @ElementCollection(targetClass = Long.class) // Assuming genre IDs are numbers
    private List<Long> moviesWatched;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getMoviesWatched() {
        return moviesWatched;
    }

    public void setMoviesWatched(List<Long> moviesWatched) {
        this.moviesWatched = moviesWatched;
    }
}
