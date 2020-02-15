package ru.hiendsys.UserManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.hiendsys.UserManagement.entities.UserAccount;
import ru.hiendsys.UserManagement.services.UserAccountService;

@Component
public class ApplicationAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        final UserAccount userAccount = userAccountService.findByUsername(name);
        if (userDetailsService.loadUserByUsername(name) != null && userAccount.isEnabled()) {
            return new UsernamePasswordAuthenticationToken(
                    name, password, userAccount.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
