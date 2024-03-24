package com.nexxy.services.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexxy.entities.movie.Movie;
import com.nexxy.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class DataExportService {
    @Autowired
    private MovieRepository movieRepository; // Inject your JPA repository

    @Autowired
    private ObjectMapper objectMapper; // Inject ObjectMapper for JSON serialization

    public void exportMoviesToJSON() throws IOException {
        List<Movie> movies = movieRepository.findAll(); // Retrieve all movies

        String json = objectMapper.writeValueAsString(movies); // Serialize to JSON

        // Write JSON to file (replace with your desired location and filename)
        FileWriter writer = new FileWriter("movies.json");
        writer.write(json);
        writer.close();
    }

}
