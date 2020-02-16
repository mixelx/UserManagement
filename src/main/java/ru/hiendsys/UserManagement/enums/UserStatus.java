package ru.hiendsys.UserManagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Statuses.
 */
@AllArgsConstructor
@Getter
public enum UserStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String text;
}
