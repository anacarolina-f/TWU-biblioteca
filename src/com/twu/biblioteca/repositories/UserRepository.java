package com.twu.biblioteca.repositories;

import com.twu.biblioteca.enums.UserType;
import com.twu.biblioteca.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("CUS-1234", "password", "Judith Viorst", UserType.CUSTOMER),
            new User("LIB-1234", "password", "Peggy Parish", UserType.LIBRARIAN)
    ));

    public List<User> getListOfUsers() {
        return users;
    }

}
