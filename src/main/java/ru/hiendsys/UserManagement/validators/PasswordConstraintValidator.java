package ru.hiendsys.UserManagement.validators;

import org.passay.AllowedRegexRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import ru.hiendsys.UserManagement.validators.annotations.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

import static java.lang.String.join;
import static java.util.Arrays.asList;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(final ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        final PasswordValidator validator = new PasswordValidator(asList(
                new LengthRule(3, 16),
                new CharacterRule(EnglishCharacterData.Alphabetical, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new AllowedRegexRule("^[A-Za-z0-9]+$")
        ));
        final RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()){
            return true;
        }
        final List<String> messages = validator.getMessages(result);
        final String message = join(",", messages);
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
