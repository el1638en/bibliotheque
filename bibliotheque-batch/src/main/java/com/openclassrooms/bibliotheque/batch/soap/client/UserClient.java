package com.openclassrooms.bibliotheque.batch.soap.client;

import com.openclassrooms.bibliotheque.ws.GetUserByLoginAndPasswordRequest;
import com.openclassrooms.bibliotheque.ws.GetUserByLoginAndPasswordResponse;
import com.openclassrooms.bibliotheque.ws.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport {

    @Value("${bibliotheque.ws.url}")
    private String bibliothequeWsUrl;

    /**
     * Client SOAP WS-Service pour rechercher un utilisateur à partir du login et du mot de passe.
     * @param login login de l'utilisateur
     * @param password mot de passe de l'utilisateur
     * @return
     */
    public User getUserByLoginAndPasswordResponse(String login, String password) {
        GetUserByLoginAndPasswordRequest request = new GetUserByLoginAndPasswordRequest();
        request.setLogin(login);
        request.setPassword(password);
        GetUserByLoginAndPasswordResponse response = (GetUserByLoginAndPasswordResponse) getWebServiceTemplate()
                .marshalSendAndReceive(bibliothequeWsUrl, request,
                        new SoapActionCallback(
                                "http://openclassrooms.com/projects/bibliotheque/GetUserByLoginAndPasswordRequest"));
        return response.getUser();
    }
}
