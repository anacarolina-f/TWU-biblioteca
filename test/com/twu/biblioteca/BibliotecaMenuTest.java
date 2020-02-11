package com.twu.biblioteca;


import com.twu.biblioteca.services.MenuService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaMenuTest {

    private MenuService menu;

    @Before
    public void setUp() {
        menu = new MenuService();
    }

    @Test
    public void showMainMenu() {
        String expected = "Menu of Options: \n" +
                "(type the number of the option) \n" +
                "1 - List of Books \n" +
                "2 - Checkout a book \n" +
                "3 - Return a book\n" +
                "4 - List of Movies\n" +
                "0 - Quit";
        assertEquals(expected, menu.showMainMenu());
    }

    @Test
    public void shouldShowCheckoutMenuMessageWhenChooseOptionTwo() {
        int option = 2;
        String expected = "Checkout Menu: Type the book ID to checkout the book: ";
        assertThat(menu.showCheckoutMenu(option), is(expected));
    }

}
