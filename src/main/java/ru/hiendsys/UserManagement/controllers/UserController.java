package ru.hiendsys.UserManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hiendsys.UserManagement.entities.UserAccount;

import javax.validation.Valid;

@Controller
public class UserController {

    @PostMapping
    public String createUserAccount(@Valid @ModelAttribute("userAccount")UserAccount userAccount,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createUserAccount";
        }
        return "list";
    }

    @GetMapping("/list")
    public String getUserAccountsList() {
        return "list";
    }

}
