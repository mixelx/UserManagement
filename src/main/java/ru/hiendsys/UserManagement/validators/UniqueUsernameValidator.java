package ru.hiendsys.UserManagement.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;
import ru.hiendsys.UserManagement.services.UserAccountService;

@Component
public class UniqueUsernameValidator implements Validator {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserAccountDto userAccountDto = (UserAccountDto) o;
        if (userAccountService.findByUsername(userAccountDto.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username", "Someone already has this username.");
        }
    }
}
