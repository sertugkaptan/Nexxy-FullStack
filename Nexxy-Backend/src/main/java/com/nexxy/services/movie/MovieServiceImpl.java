package com.nexxy.services.movie;

import com.nexxy.entities.movie.Movie;
import com.nexxy.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository; // Assuming a repository for data access
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Override
    public List<Movie> getBannerMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElse(new Movie());
    }
}
