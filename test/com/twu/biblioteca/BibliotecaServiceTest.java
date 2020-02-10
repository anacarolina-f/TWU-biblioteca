package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaServiceTest {

    private BibliotecaService bibliotecaService;
    private BookService bookService;
    private BibliotecaMenu menu;
    private BibliotecaRepository repository;
    private List<Book> books;

    //FAZER STUB DO SERVICE SEM USER INPUT?
    //USAR INJECAO NO SERVICE?

    @Before
    public void setUp() {
        bibliotecaService = new BibliotecaService();
        bookService = new BookService();
        menu = new BibliotecaMenu();
        repository = new BibliotecaRepository();
        books = repository.getListOfBooks();
    }

    @Test
    public void welcomeMessageWhenStarts() {
        String expected = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
//        assertEquals(expected, bibliotecaService.start());
    }

    @Test
    public void listOfBooksContainsBook() {
        String expected = repository.getListOfBooks().get(0).toString();
        assertThat(bookService.getListAvailableBooks(), hasItems(expected));
    }

    @Test
    public void showMenu() {
        String expected = "Menu of Options: \n" +
                "(type the number of the option) \n" +
                "1 - List of Books \n" +
                "2 - Checkout a book \n" +
                "3 - Return a book" +
                "0 - Quit";
        assertEquals(expected, menu.showMainMenu());
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

    //NOT
    @Test
    public void shouldShowCheckoutMenuMessageWhenChooseOptionTwo() {
        int option = 2;
        String expected = "Checkout Menu: Type the book ID to checkout the book: ";
        assertThat(menu.showCheckoutMenu(), is(expected));
    }

    @Test
    public void shouldShowMessageWhenCheckOutABookWithSuccess() {
        String expected = "Thank you! Enjoy the book!";
        assertThat(bookService.checkoutBook(1), is(expected));
    }

    @Test
    public void shouldShowMessageWhenCheckOutABookWithoutSuccess() {
        String expected = "Sorry, that book is not available.";
        books.get(0).setAvailable(false);
        assertThat(bookService.checkoutBook(1), is(expected));
    }

}
