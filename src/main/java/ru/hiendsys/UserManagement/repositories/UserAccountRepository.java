package ru.hiendsys.UserManagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hiendsys.UserManagement.entities.UserAccount;

/**
 * Repository for storing user accounts.
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    /**
     * Find user account by username.
     *
     * @param username username.
     * @return user account with given username.
     */
    UserAccount findByUsername(String username);

    /**
     * Return page of user accounts.
     *
     * @param pageable pageble.
     * @return user accounts page.
     */
    Page<UserAccount> findAll(Pageable pageable);
}
