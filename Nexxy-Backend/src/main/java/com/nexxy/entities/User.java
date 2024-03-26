package com.nexxy.entities;

import jakarta.persistence.ElementCollection;
import org.springframework.data.annotation.Id;

import java.util.List;

public class User {

    @Id
    private Long id;
    private String username;
    private String email;
    private String password;

    @ElementCollection(targetClass = Movie.class) // Assuming genre IDs are numbers
    private List<Movie> moviesWatched;

}
