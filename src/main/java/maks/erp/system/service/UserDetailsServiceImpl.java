package maks.erp.system.service;

import lombok.extern.slf4j.Slf4j;
import maks.erp.system.login.LoginUserDetails;
import maks.erp.system.model.user.User;
import maks.erp.system.utils.UserRoleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duity
 * @since 6/1/24
 */

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        log.info("Inside loadUserByUsername");

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for(String role: UserRoleUtils.rolePermissions.get(user.getCategory())) {
            System.out.println("Role: " + role);
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            grantedAuthorities.add(grantedAuthority);
        }

        return new LoginUserDetails(user, grantedAuthorities);
    }
}
