package ru.hiendsys.UserManagement.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hiendsys.UserManagement.enums.Role;
import ru.hiendsys.UserManagement.enums.UserStatus;
import ru.hiendsys.UserManagement.validators.annotations.ValidPassword;

import javax.validation.constraints.Pattern;

import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_FIRST_NAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_LAST_NAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_USERNAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationRegexes.ONLY_LATIN_CHARACTERS;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {

    private Long id;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_USERNAME_MESSAGE)
    private String username;

    @ValidPassword
    private String password;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_FIRST_NAME_MESSAGE)
    private String firstName;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_LAST_NAME_MESSAGE)
    private String lastName;

    private UserStatus status;

    private Role role;

}
