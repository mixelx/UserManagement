package ru.hiendsys.UserManagement.entities.dto;

import org.springframework.stereotype.Component;
import ru.hiendsys.UserManagement.entities.UserAccount;

import java.util.HashSet;

import static java.time.LocalDateTime.now;
import static java.util.Collections.singletonList;
import static ru.hiendsys.UserManagement.enums.Role.ADMIN;
import static ru.hiendsys.UserManagement.enums.Role.USER;

/**
 * Mapper for User Account DTOs.
 */
@Component
public class UserAccountMapper {

    public UserAccount convertDtoToEntity(final UserAccountDto userAccountDto){
        return UserAccount.builder()
                .id(userAccountDto.getId())
                .username(userAccountDto.getUsername())
                .firstName(userAccountDto.getFirstName())
                .lastName(userAccountDto.getLastName())
                .password(userAccountDto.getPassword())
                .status(userAccountDto.getStatus())
                .roles(new HashSet<>(singletonList(userAccountDto.getRole())))
                .dateCreated(now())
                .build();
    }

    public BaseUserAccountDto convertEntityToDtoForViewPage(final UserAccount userAccount) {
        return BaseUserAccountDto.builder()
                .id(userAccount.getId())
                .username(userAccount.getUsername())
                .firstName(userAccount.getFirstName())
                .lastName(userAccount.getLastName())
                .role(userAccount.getAuthorities().contains(ADMIN) ? ADMIN : USER)
                .status(userAccount.getStatus())
                .build();
    }

}
