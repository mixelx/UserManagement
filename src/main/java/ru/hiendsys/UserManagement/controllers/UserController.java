package ru.hiendsys.UserManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;
import ru.hiendsys.UserManagement.enums.UserStatus;
import ru.hiendsys.UserManagement.services.UserAccountService;
import ru.hiendsys.UserManagement.validators.UniqueUsernameValidator;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UniqueUsernameValidator usernameValidator;

    @GetMapping("/new")
    public String getCreateUserAccountPage(final Model model) {
        model.addAttribute("user", new UserAccountDto());
        return "createPage";
    }

    @PostMapping("/new")
    public String createUserAccount(@Valid @ModelAttribute("userAccount") final UserAccountDto userAccount,
                                    final BindingResult bindingResult) {
        usernameValidator.validate(userAccount, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createPage";
        }
        userAccountService.saveUserAccount(userAccount);
        return "redirect:/user";
    }

    @GetMapping
    public String getUserAccountsList(final Model model,
                                      @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 9) final Pageable pageable) {
        userAccountService.addPageableAttributes(model, pageable);
        return "list";
    }

    @GetMapping("/{userId}")
    public String getUserAccountProfile(@PathVariable final Long userId, final Model model) {
        model.addAttribute("user", userAccountService.getUserAccountDtoById(userId));
        return "profile";
    }

    @PostMapping("/switchStatus/{userId}")
    @ResponseBody
    public UserStatus switchUserStatus(@PathVariable final Long userId) {
        return userAccountService.switchUserStatus(userId);
    }

    @GetMapping("{userId}/edit")
    public String getEditPage(@PathVariable final Long userId, final Model model) {
        model.addAttribute("user", userAccountService.getUserAccountById(userId));
        return "editPage";
    }
}
