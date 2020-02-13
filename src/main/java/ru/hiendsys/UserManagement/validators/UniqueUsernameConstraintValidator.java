package ru.hiendsys.UserManagement.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import ru.hiendsys.UserManagement.services.UserAccountService;
import ru.hiendsys.UserManagement.validators.annotations.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameConstraintValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private ApplicationContext context;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userAccountService.findByUsername(username) == null;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }
}
