package ru.hiendsys.UserManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.services.UserAccountService;

import javax.validation.Valid;

@Controller()
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/new")
    public String getCreateUserAccountPage(final Model model) {
        model.addAttribute("userAccount", new UserAccount());
        return "createPage";
    }

    @PostMapping("/new")
    public String createUserAccount(@Valid @ModelAttribute("userAccount") UserAccount userAccount,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createPage";
        }
        userAccountService.saveUserAccount(userAccount);
        return "list";
    }

    @GetMapping("/list")
    public String getUserAccountsList() {
        return "list";
    }

}
