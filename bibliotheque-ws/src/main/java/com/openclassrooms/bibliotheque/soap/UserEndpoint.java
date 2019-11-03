package com.openclassrooms.bibliotheque.soap;

import com.openclassrooms.bibliotheque.models.User;
import com.openclassrooms.bibliotheque.service.UserService;
import com.openclassrooms.projects.bibliotheque.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static org.springframework.beans.BeanUtils.copyProperties;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://openclassrooms.com/projects/bibliotheque";

    @Autowired
    private UserService userService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByLoginAndPasswordRequest")
    @ResponsePayload
    public GetUserByLoginAndPasswordResponse getUserByLoginAndPassword(@RequestPayload GetUserByLoginAndPasswordRequest request) {
        GetUserByLoginAndPasswordResponse response = new GetUserByLoginAndPasswordResponse();
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        if (user != null) {
            UserWs userWs = new UserWs();
            copyProperties(user, userWs);
            response.setUserWs(userWs);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CreateUserResponse createUserResponse = new CreateUserResponse();
        User user = new User();
        copyProperties(request.getUserWs(), user);
        User userCreated = userService.create(user);
        if (userCreated != null) {
            UserWs userWs = new UserWs();
            copyProperties(userCreated, userWs);
            createUserResponse.setUserWs(userWs);
        }
        return createUserResponse;
    }
}
