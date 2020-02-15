package ru.hiendsys.UserManagement.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.entities.dto.BaseUserAccountDto;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;
import ru.hiendsys.UserManagement.enums.UserStatus;

public interface UserAccountService {

    void saveUserAccount(UserAccountDto userAccountDto);

    UserAccount findByUsername(String username);

    Page<UserAccount> getAllAccountsPage(Pageable pageable);

    void addPageableAttributes(Model model, Pageable pageable);

    BaseUserAccountDto getUserAccountDtoById(Long id);

    UserStatus switchUserStatus(Long userId);

    void editUserAccount(Long userId, BaseUserAccountDto userAccount);
}
