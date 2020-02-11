package com.twu.biblioteca.services;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.repositories.UserRepository;

public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public User userLogin(String id, String password) {
            return userRepository.getListOfUsers()
                    .stream()
                    .filter(user -> user.getId().equalsIgnoreCase(id))
                    .filter(user -> user.getPassword().equalsIgnoreCase(password))
                    .findFirst()
                    .orElse(null);
    }
}
