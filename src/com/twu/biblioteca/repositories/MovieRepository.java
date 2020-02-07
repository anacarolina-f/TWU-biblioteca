package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {

    private static List<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie(1, "FORD V FERRARI", "Peter Chernin", "2019",1),
            new Movie(2, "THE IRISHMAN", "Martin Scorsese","2019",5),
            new Movie(3, "JOJO RABBIT", "Carthew Neal", "2019",3),
            new Movie(4, "JOKER", "Todd Phillips", "2019",2),
            new Movie(5, "LITTLE WOMEN", "Amy Pascal", "2019",2),
            new Movie(6, "MARRIAGE STORY", "Noah Baumbach", "2019",2),
            new Movie(7, "1917", "Sam Mendes", "2019",1),
            new Movie(7, "ONCE UPON A TIME...IN HOLLYWOOD", "David Heyman", "2019",1),
            new Movie(7, "PARASITE", "Kwak Sin Ae and Bong Joon Ho", "2019",5)
    ));

    public List<Movie> getListOfMovies() {
        return movies;
    }

}
