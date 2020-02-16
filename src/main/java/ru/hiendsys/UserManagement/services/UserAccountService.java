package ru.hiendsys.UserManagement.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.entities.dto.BaseUserAccountDto;
import ru.hiendsys.UserManagement.entities.dto.UserAccountDto;
import ru.hiendsys.UserManagement.enums.UserStatus;

public interface UserAccountService {

    /**
     * Convert dto to entity and save it to database.
     *
     * @param userAccountDto dto to save.
     */
    void saveUserAccount(UserAccountDto userAccountDto);

    /**
     * Find user account entity from database by username.
     *
     * @param username searching username.
     * @return user account from database.
     */
    UserAccount findByUsername(String username);

    /**
     * Get page with all user accounts.
     *
     * @param pageable pageable attributes.
     * @return page with all user accounts.
     */
    Page<UserAccount> getAllAccountsPage(Pageable pageable);

    /**
     * Add pageable attributes to model for view.
     *
     * @param model    model for view.
     * @param pageable pageable attributes.
     */
    void addPageableAttributes(Model model, Pageable pageable);

    /**
     * Get user account dto by entity's id.
     *
     * @param id user account id.
     * @return founded dto.
     */
    BaseUserAccountDto getUserAccountDtoById(Long id);

    /**
     * Change user status to the opposite one.
     *
     * @param userId user account id.
     * @return new status.
     */
    UserStatus switchUserStatus(Long userId);

    /**
     * Edit user account data.
     *
     * @param userId      user account id.
     * @param userAccount dto with a new data.
     */
    void editUserAccount(Long userId, BaseUserAccountDto userAccount);
}
