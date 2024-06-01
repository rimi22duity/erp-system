package maks.erp.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duity
 * @since 5/5/24
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "user_login";
    }
}
