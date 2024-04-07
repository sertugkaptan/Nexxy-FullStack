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

}
