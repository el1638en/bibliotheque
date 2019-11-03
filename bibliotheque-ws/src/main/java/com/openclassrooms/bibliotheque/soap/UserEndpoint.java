package com.openclassrooms.bibliotheque.soap;

import com.openclassrooms.bibliotheque.repository.UserRepository;
import com.openclassrooms.projects.bibliotheque.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.openclassrooms.projects.bibliotheque.Status.NOT_FOUND;
import static com.openclassrooms.projects.bibliotheque.Status.SUCCESS;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://openclassrooms.com/projects/bibliotheque";

    @Autowired
    private UserRepository userRepository;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByLoginAndPasswordRequest")
    @ResponsePayload
    public GetUserByLoginAndPasswordResponse getUserByNameAndPassword(@RequestPayload GetUserByLoginAndPasswordRequest request) {
        GetUserByLoginAndPasswordResponse response = new GetUserByLoginAndPasswordResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        com.openclassrooms.bibliotheque.models.User findUser = userRepository.findByNameAndPassword(request.getLogin(), request.getPassword());
        if (findUser == null) {
            serviceStatus.setStatus(NOT_FOUND);
        } else {
            serviceStatus.setStatus(SUCCESS);
            User user = new User();
            BeanUtils.copyProperties(findUser, user);
            response.setUser(user);
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
