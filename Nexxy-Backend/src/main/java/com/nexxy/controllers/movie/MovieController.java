package com.nexxy.controllers.movie;

import com.nexxy.entities.Movie;
import com.nexxy.services.movie.MovieService;
import com.nexxy.services.util.DataExportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/web/api")
@CrossOrigin(origins = "*") // Replace with your Angular app domain
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService movieService;
    @Autowired
    private DataExportService dataService;

    @GetMapping("/movies")
    public List<Movie> getBannerMovies() {
        return movieService.getBannerMovies();
    }

    @PostMapping(value = "/movie") // Handles POST requests to this endpoint
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        if (logger.isDebugEnabled()) {
            logger.info("Movie id:" + movie.getId());
        }
        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().body("No title");
        }
        Movie savedMovie = movieService.saveMovie(movie); // Call your service to save the movie
        return ResponseEntity.ok("Sucessfully Saved!");
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/export-movies")
    public ResponseEntity<String> exportMovies() {
        try {
            dataService.exportMoviesToJSON();
            return ResponseEntity.ok("Sucessfully Exported");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
