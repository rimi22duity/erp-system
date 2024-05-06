package maks.erp.system.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duity
 * @since 5/5/24
 */

@Controller
public class ERPErrorController implements ErrorController {

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}