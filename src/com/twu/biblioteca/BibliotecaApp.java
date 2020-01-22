package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaService service = new BibliotecaService();

        System.out.println(service.welcomeMessage());
        System.out.println(service.getListOfBooks());
    }
}
