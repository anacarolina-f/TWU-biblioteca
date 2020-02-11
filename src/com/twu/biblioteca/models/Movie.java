package com.twu.biblioteca.models;

public class Movie {
    private Integer id;
    private String name;
    private String director;
    private String year;
    private int rating;
    private boolean available;

    public Movie() {
    }

    public Movie(Integer id, String name, String director, String year, int rating) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.available = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "#" + getId() +
                " -- Name: " + getName() +
                " -- Director: '" + getDirector() +
                " -- Year Published: '" + getYear() +
                " -- Rating: " + getRating() + ".\n";
    }
}
