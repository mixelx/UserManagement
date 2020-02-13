package ru.hiendsys.UserManagement.services;

import ru.hiendsys.UserManagement.entities.UserAccount;

public interface UserAccountService {

    void saveUserAccount(UserAccount userAccount);

    UserAccount findByUsername(String username);

}
