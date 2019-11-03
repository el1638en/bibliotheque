package com.openclassrooms.bibliotheque.controllers;

import com.openclassrooms.bibliotheque.models.Login;
import com.openclassrooms.bibliotheque.service.UserService;
import com.openclassrooms.bibliotheque.ws.UserWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String welcome(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping(path = "/login")
    public String login(Model model, @ModelAttribute("login") Login login) {
//        User user = userService.create(login.getLogin(), "FISRT_NAME_TEST", "NAME_TEST", login.getPassword());
        UserWs userWs = userService.findUser(login.getLogin(), login.getPassword());
        if (userWs != null) {
            model.addAttribute("message", "Hello Mister " + userWs.getFirstName() + " "+ userWs.getName());
        } else {
            model.addAttribute("message", "Wrong login and/or password.");
        }
        return "login";
    }
}
