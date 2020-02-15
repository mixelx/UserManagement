package ru.hiendsys.UserManagement.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hiendsys.UserManagement.validators.annotations.ValidPassword;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto extends BaseUserAccountDto {

    @ValidPassword
    private String password;
}
