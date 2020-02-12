package com.twu.biblioteca;

import com.twu.biblioteca.enums.UserType;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.services.BibliotecaService;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.ConsoleInteractions;
import com.twu.biblioteca.services.MenuService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaServiceTest {

    private BibliotecaService bibliotecaService;
    private ConsoleInteractions console;
    private BookService bookService;
    private MenuService menu;
    private BookRepository repository;
    private List<Book> books;

    @Before
    public void setUp() {
        console = new ConsoleInteractions();
//        console = mock(ConsoleInteractions.class);
        bibliotecaService = new BibliotecaService();
        bookService = new BookService();
        menu = new MenuService();
        repository = new BookRepository();
        books = repository.getListOfBooks();
    }

    @Test
    public void welcomeMessageWhenStarts() {
        bibliotecaService.start();
        String expected = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
//        assertEquals(expected, console.printMessage(""));
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
        assertThat(menu.showCheckoutMenu(option), is(expected));
    }

    @Test
    public void shouldShowMessageWhenCheckOutABookWithSuccess() {
        String expected = "Thank you! Enjoy the book!";
        User user = new User("000-6666", "password", "Peggy Parish", "email@email.com", "333-33-44", UserType.CUSTOMER);
        assertThat(bookService.checkoutBook(user, 1), is(expected));
    }

    @Test
    public void shouldShowMessageWhenCheckOutABookWithoutSuccess() {
        String expected = "Sorry, that book is not available.";
        books.get(0).setAvailable(false);
        User user = new User("000-6666", "password", "Peggy Parish", "email@email.com", "333-33-44", UserType.CUSTOMER);
        assertThat(bookService.checkoutBook(user, 1), is(expected));
    }

}
