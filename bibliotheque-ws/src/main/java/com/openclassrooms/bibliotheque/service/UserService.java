package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.User;

public interface UserService {

    User findByLoginAndPassword(String login, String password);

    User create(User user);
}
