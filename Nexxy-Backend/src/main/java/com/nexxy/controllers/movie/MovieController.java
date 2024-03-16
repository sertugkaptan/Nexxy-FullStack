package com.nexxy.controllers.movie;

import com.nexxy.entities.movie.Movie;
import com.nexxy.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/web/api")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getBannerMovies() {
        return movieService.getBannerMovies();
    }

    @PostMapping("/addmovie")
    public Movie addMovies(@RequestBody Movie movie) {
        
        return movieService.addMovies(movie);
    }

}
