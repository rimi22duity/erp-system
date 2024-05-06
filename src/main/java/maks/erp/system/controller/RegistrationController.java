package maks.erp.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duity
 * @since 5/7/24
 */

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
