package ru.hiendsys.UserManagement.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * User account roles.
 */
public enum Role implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
