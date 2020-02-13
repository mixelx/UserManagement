package ru.hiendsys.UserManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hiendsys.UserManagement.entities.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    /**
     * Find user account by username.
     *
     * @param username username.
     * @return user account with given username.
     */
    UserAccount findByUsername(String username);

}
