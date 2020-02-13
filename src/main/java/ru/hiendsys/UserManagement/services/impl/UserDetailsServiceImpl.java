package ru.hiendsys.UserManagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.repositories.UserAccountRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserAccount userAccount = userAccountRepository.findByUsername(username);
        if (userAccount == null) throw new UsernameNotFoundException(username);
        final Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        userAccount.getRoles()
                .forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.name())));
        return new User(userAccount.getUsername(), userAccount.getPassword(), grantedAuthorities);
    }
}
