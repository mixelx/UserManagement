package ru.hiendsys.UserManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(final Model model, final String error) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        return "login";
    }

    @GetMapping("/")
    public String redirectToUsersListPage() {
        return "redirect:/user";
    }
}
