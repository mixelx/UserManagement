package ru.hiendsys.UserManagement.validators.annotations;

import ru.hiendsys.UserManagement.validators.PasswordConstraintValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface ValidPassword {

}
