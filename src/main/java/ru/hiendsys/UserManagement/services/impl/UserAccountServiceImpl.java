package ru.hiendsys.UserManagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;
import ru.hiendsys.UserManagement.entities.dto.UserAccountMapper;
import ru.hiendsys.UserManagement.repositories.UserAccountRepository;
import ru.hiendsys.UserManagement.services.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public void saveUserAccount(final UserAccountDto userAccountDto) {
        userAccountDto.setPassword(passwordEncoder.encode(userAccountDto.getPassword()));
        userAccountRepository.save(userAccountMapper.convertDtoToEntity(userAccountDto));
    }

    @Override
    public UserAccount findByUsername(final String username) {
        return userAccountRepository.findByUsername(username);
    }
}
