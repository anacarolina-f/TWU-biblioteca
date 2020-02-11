package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.ItemNotFoundException;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.repositories.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository repository = new MovieRepository();

    public MovieService() {
    }

    public List<String> getListAvailableMovies() {
        return repository.getListOfMovies().stream()
                .filter(Movie::isAvailable)
                .map(Movie::toString)
                .collect(Collectors.toList());
    }

    public String checkoutMovie(int bookID) {
        List<Movie> moviesAvailable = repository.getListOfMovies();
        for (Movie movie : moviesAvailable) {
            if (movie.getId() == bookID) {
                if (movie.isAvailable()) {
                    movie.setAvailable(false);
                    return "Thank you! Enjoy the movie!";
                }
                else return "Sorry, that movie is not available.";
            }
        }
        return new ItemNotFoundException("Movie not found!").getMessage();
    }
}
