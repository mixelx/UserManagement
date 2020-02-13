package ru.hiendsys.UserManagement.validators;

import org.springframework.beans.factory.annotation.Autowired;
import ru.hiendsys.UserManagement.repositories.UserAccountRepository;
import ru.hiendsys.UserManagement.validators.annotations.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameConstraintValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userAccountRepository.findByUsername(username) == null;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }
}
