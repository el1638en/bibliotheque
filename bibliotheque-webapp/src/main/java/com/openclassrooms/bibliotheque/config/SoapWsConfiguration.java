package com.openclassrooms.bibliotheque.config;

import com.openclassrooms.bibliotheque.soap.client.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapWsConfiguration {

    @Value("${bibliotheque.ws}")
    private String bibliothequeWs;
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setPackagesToScan("com.openclassrooms.bibliotheque.ws");
        return marshaller;
    }

    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller) {
        UserClient client = new UserClient();
        client.setDefaultUri(bibliothequeWs);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
