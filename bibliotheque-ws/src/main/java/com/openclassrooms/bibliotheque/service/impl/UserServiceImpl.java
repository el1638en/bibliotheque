package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.models.User;
import com.openclassrooms.bibliotheque.repository.UserRepository;
import com.openclassrooms.bibliotheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
}
