package ru.hiendsys.UserManagement.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;

public interface UserAccountService {

    void saveUserAccount(UserAccountDto userAccountDto);

    UserAccount findByUsername(String username);

    Page<UserAccount> getAllAccountsPage(Pageable pageable);

    void addPageableAttributes(Model model, Pageable pageable);
}
