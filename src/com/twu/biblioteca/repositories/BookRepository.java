package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepository {

    private static List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, "Alexander and the Terrible", "Judith Viorst", "1972"),
            new Book(2, "Amelia Bedelia", "Peggy Parish", "1963"),
            new Book(3, "Bark, George", "Jules Feiffer", "1999"),
            new Book(4, "Because of Winn-Dixie", "Kate DiCamillo", "2000"),
            new Book(5, "Bridge to Terabithia", "Katherine Paterson", "1977"),
            new Book(6, "Curious George", "H.A. Rey", "1941"),
            new Book(7, "Freight Train", "Donald Crews", "1978")
    ));

    public List<Book> getListOfBooks() {
        return books;
    }

}
