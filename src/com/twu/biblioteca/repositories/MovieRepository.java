package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {

    private static List<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie(1, "Alexander and the Terrible", "Judith Viorst", "1972", 5),
            new Movie(2, "Amelia Bedelia", "Peggy Parish", "1963", 5),
            new Movie(3, "Bark, George", "Jules Feiffer", "1999", 3),
            new Movie(4, "Because of Winn-Dixie", "Kate DiCamillo", "2000", 2),
            new Movie(5, "Bridge to Terabithia", "Katherine Paterson", "1977", 2),
            new Movie(6, "Curious George", "H.A. Rey", "1941", 2),
            new Movie(7, "Freight Train", "Donald Crews", "1978", 1)
    ));

    public List<Movie> getListOfBooks() {
        return movies;
    }

}
