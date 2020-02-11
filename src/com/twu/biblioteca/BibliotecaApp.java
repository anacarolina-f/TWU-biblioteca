package com.twu.biblioteca;

import com.twu.biblioteca.services.BibliotecaService;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaService service = new BibliotecaService();
        service.start();
    }
}
