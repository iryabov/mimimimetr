package mimimimetr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mimimimetr.entity.User;
import mimimimetr.service.UserService;


@Controller
public class RegistrationController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("newUser", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("newUser") @Valid User newUser, BindingResult bindingResult) {
        User userFromDb = userService.findByUsername(newUser.getUsername());
        if (userFromDb != null) {
            bindingResult.rejectValue("username", "alreadyExist", "Такой пользователь уже существует");
        }
        
        if (bindingResult.hasErrors()) {

            return "registration";
        } else {
            userService.addUser(newUser);
        }

        return "redirect:/login";
    }
}
