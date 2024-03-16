package com.nexxy.services.movie;

import com.nexxy.entities.movie.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    public List<Movie> getBannerMovies();

    public Movie addMovies(Movie movie);

}
