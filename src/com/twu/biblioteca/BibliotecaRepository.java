package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepository {

    private static List<Book> books = new ArrayList<Book>();

    public static List<Book> getListOfBooks() {
        books.add( new Book("Alexander and the Terrible", "Judith Viorst",  "1972"));
        books.add(new Book("Amelia Bedelia", "Peggy Parish", "1963"));
        books.add(new Book("Bark, George", "Jules Feiffer", "1999"));
        books.add(new Book("Because of Winn-Dixie", "Kate DiCamillo", "2000"));
        books.add(new Book("Bridge to Terabithia",  "Katherine Paterson", "1977"));
        books.add(new Book("Curious George", "H.A. Rey", "1941"));
        books.add(new Book("Freight Train", "Donald Crews", "1978"));

        return books;
    }

}
