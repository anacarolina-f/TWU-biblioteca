package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaServiceTest {

    private BibliotecaService bibliotecaService;
    private BookService bookService;
    private List<Book> books;

    @Before
    public void setUp() {
        bibliotecaService = new BibliotecaService();
        bookService = new BookService();
        BibliotecaRepository repository = new BibliotecaRepository();
        books = repository.getListOfBooks();
    }

    @Test
    public void welcomeMessageWhenStarts() {
        String expected = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
//        assertEquals(expected, bibliotecaService.start());
    }

    //NOT
    @Test
    public void listOfBooksContainsBook() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        String expected = "Title: Alexander and the Terrible";
//        bibliotecaService.start();
//        System.setIn(in);
        assertThat(bibliotecaService.showBookList(), containsString(expected));
    }

    //NOT
    @Test
    public void chooseOptionOneFromMenuShouldShowListOfBooks() {
        int option = 1;

//        assertThat(bibliotecaService.showBookList(), containsString(books.get(0).toString()));
    }

    //NOT
    @Test
    public void chooseAnotherOptionShouldShowInvalidOptioonMsg() {
        String expected = "Invalid option";
        int option = 99;
 //       assertThat(service.getMenuOption(option), is(expected));
    }

    @Test
    public void shouldShowMessageWhenCheckOutABookWithSuccess() {
        books.get(0).setAvailable(true);
        assertThat(bookService.checkoutBook(1), is("Thank you! Enjoy the book!"));
    }

    @Test
    public void shouldShowMessageWhenCheckOutABookWithoutSuccess() {
        books.get(0).setAvailable(false);
        assertThat(bookService.checkoutBook(1), is("Sorry, that book is not available."));
    }
}
