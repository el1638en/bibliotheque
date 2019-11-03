package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.User;

public interface UserService {

    User findByNameAndPassword(String name, String password);
}
