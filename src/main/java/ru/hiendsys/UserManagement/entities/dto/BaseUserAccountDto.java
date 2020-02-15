package ru.hiendsys.UserManagement.entities.dto;

import ru.hiendsys.UserManagement.enums.Role;
import ru.hiendsys.UserManagement.enums.UserStatus;

import javax.validation.constraints.Pattern;

import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_FIRST_NAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_LAST_NAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_USERNAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationRegexes.ONLY_LATIN_CHARACTERS;

public class BaseUserAccountDto {

    private Long id;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_USERNAME_MESSAGE)
    private String username;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_FIRST_NAME_MESSAGE)
    private String firstName;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_LAST_NAME_MESSAGE)
    private String lastName;

    private UserStatus status;

    private Role role;

}
