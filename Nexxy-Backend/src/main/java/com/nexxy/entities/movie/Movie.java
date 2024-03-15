package com.nexxy.entities.movie;

import jakarta.persistence.*;
import org.hibernate.annotations.Array;

import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name="listOfUsers")
    private List<Long> genre_ids;

    private Boolean adult;

    private String backdrop_path;

    private String media_type;
    private String original_language;
    private String original_title;
    private String overview;
    private String poster_path;
    private String title;
    private Date release_date;
    private Boolean video;
    private Long popularity;
    private Long vote_average;
    private Long vote_count;


}
