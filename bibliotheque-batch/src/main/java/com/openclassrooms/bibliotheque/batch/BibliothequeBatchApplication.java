package com.openclassrooms.bibliotheque.batch;

import com.openclassrooms.bibliotheque.batch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.openclassrooms.bibliotheque.batch")
@Configuration
@PropertySource(value="application.properties")
public class BibliothequeBatchApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BibliothequeBatchApplication.class);
        BibliothequeBatchApplication appx = context.getBean(BibliothequeBatchApplication .class);
        appx.start();
    }
    private void start() {
        System.out.println("Debut");
        System.out.println("Identification du user : "+userService.findUser("clement","CLEMENT").getName());
    }
}
