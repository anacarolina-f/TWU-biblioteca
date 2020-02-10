package com.twu.biblioteca.services;

import com.twu.biblioteca.enums.UserType;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.repositories.UserRepository;

import java.util.List;

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

    public boolean isLibrarian(User user) {
        User verified = userLogin(user.getId(), user.getPassword());
        return verified.getUserType().equals(UserType.LIBRARIAN);
    }

    private boolean checkoutUserLogin(String id, String password) {
        List<User> users = userRepository.getListOfUsers();
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(id)) {
                if (user.getPassword().equalsIgnoreCase(password)) {
                    return true;
                }
            }
            else return false;
        }
        return false;
    }
}
