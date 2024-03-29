package com.nexxy.services.movie;

import com.nexxy.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    public List<Movie> getBannerMovies();

    public Movie saveMovie(Movie movie);

    public Movie getMovie(Long id);

}
