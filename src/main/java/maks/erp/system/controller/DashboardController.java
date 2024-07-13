package maks.erp.system.controller;

import maks.erp.system.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duity
 * @since 5/6/24
 */

@Controller
public class DashboardController {
    @Autowired
    SecurityService securityService;

    @GetMapping("/dashboard")
    public String dashboard(ModelMap model) {
        model.put("loggedInUser", securityService.getLoggedInUser());
        return "dashboard";
    }
}
