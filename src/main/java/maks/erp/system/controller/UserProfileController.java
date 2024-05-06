package maks.erp.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duity
 * @since 5/4/24
 */

@Controller
public class UserProfileController {

    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }
}
