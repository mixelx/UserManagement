package ru.hiendsys.UserManagement.validators.annotations;

import ru.hiendsys.UserManagement.validators.PasswordConstraintValidator;
import ru.hiendsys.UserManagement.validators.UniqueUsernameConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.UNIQUE_USERNAME_MESSAGE;

@Documented
@Constraint(validatedBy = UniqueUsernameConstraintValidator.class)
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface UniqueUsername {

    String message() default UNIQUE_USERNAME_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
