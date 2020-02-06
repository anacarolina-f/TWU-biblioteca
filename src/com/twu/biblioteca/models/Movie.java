package com.twu.biblioteca;

public class Movie {
    private Integer id;
    private String name;
    private String director;
    private String year;
    private int rating;
    private boolean available;

    public Movie() {
    }

    public Movie(Integer id, String title, String author, String year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        available = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
                " -- Title: " + getTitle() +
                " -- Author: '" + getAuthor() +
                " -- Year Published: '" + getYear() + ".\n";
    }
}
