package ru.hiendsys.UserManagement.validators;

import ru.hiendsys.UserManagement.validators.annotations.OnlyLatinCharacters;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LatinCharactersConstraintValidator implements ConstraintValidator<OnlyLatinCharacters, String> {
    @Override
    public void initialize(OnlyLatinCharacters constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String template = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(template);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
