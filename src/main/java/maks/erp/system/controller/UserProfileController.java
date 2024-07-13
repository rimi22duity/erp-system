package maks.erp.system.controller;

import maks.erp.system.dto.UserDto;
import maks.erp.system.model.user.User;
import maks.erp.system.service.SecurityService;
import maks.erp.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author duity
 * @since 5/4/24
 */

@Controller
public class UserProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/profile")
    public String getProfile(ModelMap model) {
        model.put("loggedInUser", securityService.getLoggedInUser());
        return "profile";
    }

}
