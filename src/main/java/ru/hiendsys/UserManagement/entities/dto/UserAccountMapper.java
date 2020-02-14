package ru.hiendsys.UserManagement.entities.dto;

import org.springframework.stereotype.Component;
import ru.hiendsys.UserManagement.entities.UserAccount;

import java.util.HashSet;

import static java.time.LocalDateTime.now;
import static java.util.Collections.singletonList;

@Component
public class UserAccountMapper {

    public UserAccount convertDtoToEntity(final UserAccountDto userAccountDto){
        return UserAccount.builder()
                .username(userAccountDto.getUsername())
                .firstName(userAccountDto.getFirstName())
                .lastName(userAccountDto.getLastName())
                .password(userAccountDto.getPassword())
                .status(userAccountDto.getStatus())
                .roles(new HashSet<>(singletonList(userAccountDto.getRole())))
                .dateCreated(now())
                .build();
    }

}
