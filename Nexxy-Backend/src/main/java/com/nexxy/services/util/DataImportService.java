package com.nexxy.services.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexxy.entities.Movie;
import com.nexxy.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class DataImportService {
    private static final Logger logger = LoggerFactory.getLogger(DataImportService.class);
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ObjectMapper objectMapper;

    //    @PostConstruct
    public void importMoviesFromJSON() throws IOException {
        File jsonFile = new File("movies.json"); // Replace with your actual file path
        FileReader reader = new FileReader(jsonFile);

        // Read JSON data into a List of Movie objects
        List<Movie> movies = objectMapper.readValue(reader, new TypeReference<List<Movie>>() {
        });

        // Save each movie to the database
        for (Movie movie : movies) {
            movieRepository.save(movie);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Sucessfully imported");
        }
        reader.close();
    }
}
