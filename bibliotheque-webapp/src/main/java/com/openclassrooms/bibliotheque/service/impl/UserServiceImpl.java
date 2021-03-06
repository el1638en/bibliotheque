package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.service.UserService;
import com.openclassrooms.bibliotheque.soap.client.UserClient;
import com.openclassrooms.bibliotheque.ws.UserWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserWs findUser(String login, String password) {
        Assert.notNull(login, "Login must not be null. Login is mandatory.");
        Assert.notNull(password, "Password must not be null. Password is mandatory.");
        return userClient.getUserByLoginAndPasswordResponse(login, password);
    }

    @Override
    public UserWs create(String login, String firstName, String name, String password) {
        // Faire les vérifications fonctionnelles
        // Appel du WebService
        return userClient.createUserResponse(login, firstName, name, password);
    }
}
