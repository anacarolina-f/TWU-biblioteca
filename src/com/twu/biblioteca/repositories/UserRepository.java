package com.twu.biblioteca.repositories;

import com.twu.biblioteca.enums.UserType;
import com.twu.biblioteca.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("000-1234", "password", "Judith Viorst", "email@email.com", "333-55-55", UserType.CUSTOMER),
            new User("000-6666", "password", "Peggy Parish", "email@email.com", "333-55-55", UserType.LIBRARIAN)
    ));

    public List<User> getListOfUsers() {
        return users;
    }

}
