package maks.erp.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author duity
 * @since 5/5/24
 */

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "user_login";
    }

    @PostMapping("/login")
    public String login() {
        return "user_login";
    }
}
