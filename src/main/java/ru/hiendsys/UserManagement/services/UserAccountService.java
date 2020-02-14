package ru.hiendsys.UserManagement.services;

import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;

public interface UserAccountService {

    void saveUserAccount(UserAccountDto userAccountDto);

    UserAccount findByUsername(String username);

}
