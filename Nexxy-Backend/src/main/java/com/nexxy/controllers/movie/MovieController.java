package com.nexxy.controllers.movie;

import com.nexxy.entities.movie.Movie;
import com.nexxy.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("web/api")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String getBannerMovies() {
        return "test";
    }

}
