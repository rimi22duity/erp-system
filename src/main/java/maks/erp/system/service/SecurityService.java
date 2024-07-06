package maks.erp.system.service;

import lombok.extern.slf4j.Slf4j;
import maks.erp.system.login.LoginUserDetails;
import maks.erp.system.model.user.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * @author duity
 * @since 6/29/24
 */

@Service
@Slf4j
public class SecurityService {

    public LoginUserDetails getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            log.info("LoggedInUserService -> LoginController -> getLoggedInAccessInfo: NOT LOGGED IN");

            return null;
        }

        UsernamePasswordAuthenticationToken upAuthToken = (UsernamePasswordAuthenticationToken) authentication;

        if (isNull(upAuthToken)) {
            log.info(" LoggedInUserService -> LoginController -> getLoggedInAccessInfo: NOT LOGGED IN");

            return null;
        }

        validatePrinciple(upAuthToken.getPrincipal());
        LoginUserDetails loginUserDetails = ((LoginUserDetails) upAuthToken.getPrincipal());

        return loginUserDetails;
    }

    private static void validatePrinciple(Object principal) {
        if (!(principal instanceof LoginUserDetails)) {
            throw new IllegalArgumentException("LoggedInUserService -> LoginController -> validatePrinciple: PRINCIPLE CANNOT BE NULL!");
        }
    }
}
