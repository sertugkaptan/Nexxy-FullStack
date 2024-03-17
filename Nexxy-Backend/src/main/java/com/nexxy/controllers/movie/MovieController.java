package com.nexxy.controllers.movie;

import com.nexxy.entities.movie.Movie;
import com.nexxy.services.movie.MovieService;
import org.h2.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/web/api")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getBannerMovies() {
        return movieService.getBannerMovies();
    }

    @PostMapping("/movie") // Handles POST requests to this endpoint
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        logger.error(movie.toString());
//        Movie savedMovie = movieService.saveMovie(movie); // Call your service to save the movie
        return ResponseEntity.ok(new Movie()); // Return a 200 OK response with the saved movie
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }
}
