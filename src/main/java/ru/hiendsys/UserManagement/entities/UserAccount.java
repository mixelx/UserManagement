package ru.hiendsys.UserManagement.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import ru.hiendsys.UserManagement.enums.UserStatus;
import ru.hiendsys.UserManagement.validators.annotations.OnlyLatinCharacters;
import ru.hiendsys.UserManagement.validators.annotations.ValidPassword;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.Date;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Entity
@Data
@Builder
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OnlyLatinCharacters
    private String username;

    @ValidPassword
    private String password;

    @OnlyLatinCharacters
    private String firstName;

    @OnlyLatinCharacters
    private String lastName;

    private UserStatus status;

    @CreatedDate
    private Date dateCreated;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user"))
    @Enumerated(STRING)
    private Set<Role> roles;
}
