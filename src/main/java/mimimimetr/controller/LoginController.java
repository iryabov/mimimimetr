package mimimimetr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mimimimetr.entity.User;


@Controller
public class LoginController {

    @GetMapping("/")
    public String welcome() {

        return "redirect:login";
    }
    
    @GetMapping("/login")
    public String login() {

        return "login";
    }
    
    @PostMapping("/logout")
    public String logout() {

        return "login";
    }

}

