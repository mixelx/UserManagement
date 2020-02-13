package ru.hiendsys.UserManagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.repositories.UserAccountRepository;
import ru.hiendsys.UserManagement.services.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public void saveUserAccount(final UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findByUsername(final String username) {
        return userAccountRepository.findByUsername(username);
    }
}
