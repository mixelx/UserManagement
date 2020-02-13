package ru.hiendsys.UserManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.hiendsys.UserManagement.enums.UserStatus;
import ru.hiendsys.UserManagement.validators.annotations.UniqueUsername;
import ru.hiendsys.UserManagement.validators.annotations.ValidPassword;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static ru.hiendsys.UserManagement.enums.UserStatus.ACTIVE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_FIRST_NAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_LAST_NAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationMessages.ONLY_LATIN_CHARACTERS_USERNAME_MESSAGE;
import static ru.hiendsys.UserManagement.validators.validationUtils.ValidationRegexes.ONLY_LATIN_CHARACTERS;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue()
    private Long id;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_USERNAME_MESSAGE)
    @Column(unique = true)
    @UniqueUsername
    private String username;

    @ValidPassword
    private String password;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_FIRST_NAME_MESSAGE)
    private String firstName;

    @Pattern(regexp = ONLY_LATIN_CHARACTERS, message = ONLY_LATIN_CHARACTERS_LAST_NAME_MESSAGE)
    private String lastName;

    private UserStatus status;

    @CreatedDate
    private Date dateCreated;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(STRING)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getStatus().equals(ACTIVE);
    }
}
