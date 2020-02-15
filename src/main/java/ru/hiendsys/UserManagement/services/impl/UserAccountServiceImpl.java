package ru.hiendsys.UserManagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.entities.dto.BaseUserAccountDto;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;
import ru.hiendsys.UserManagement.entities.dto.UserAccountMapper;
import ru.hiendsys.UserManagement.enums.UserStatus;
import ru.hiendsys.UserManagement.repositories.UserAccountRepository;
import ru.hiendsys.UserManagement.services.UserAccountService;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.singletonList;
import static ru.hiendsys.UserManagement.enums.UserStatus.ACTIVE;
import static ru.hiendsys.UserManagement.enums.UserStatus.INACTIVE;

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

    @Override
    public Page<UserAccount> getAllAccountsPage(final Pageable pageable) {
        return userAccountRepository.findAll(pageable);
    }

    @Override
    public void addPageableAttributes(final Model model, Pageable pageable) {
        final Page<UserAccount> allAccountsPage = getAllAccountsPage(pageable);
        final int totalPages = allAccountsPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("pages", allAccountsPage);
    }

    @Override
    public BaseUserAccountDto getUserAccountDtoById(final Long id) {
        return userAccountMapper.convertEntityToDtoForViewPage(userAccountRepository.getOne(id));
    }

    @Override
    public UserStatus switchUserStatus(final Long userId) {
        final UserAccount userAccount = userAccountRepository.getOne(userId);
        userAccount.setStatus(userAccount.getStatus().equals(ACTIVE) ? INACTIVE : ACTIVE);
        userAccountRepository.save(userAccount);
        return userAccount.getStatus();
    }

    @Override
    public void editUserAccount(Long userId, BaseUserAccountDto userAccount) {
        final UserAccount user = userAccountRepository.getOne(userId);
        user.setUsername(userAccount.getUsername());
        user.setFirstName(userAccount.getFirstName());
        user.setLastName(userAccount.getLastName());
        user.setStatus(userAccount.getStatus());
        user.setRoles(new HashSet<>(singletonList(userAccount.getRole())));
        userAccountRepository.save(user);
    }
}
