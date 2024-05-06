package maks.erp.system.controller;

import maks.erp.system.model.user.DesignationType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author duity
 * @since 5/4/24
 */

@Controller
public class DesignationTypeController {

    public final String DESIGNATION_PAGE = "designationType";

    @GetMapping("/designations")
    public String addDesignations(ModelMap model) {
        return DESIGNATION_PAGE;
    }

    @PostMapping("/designations")
    public String designation(@Validated @ModelAttribute DesignationType designationType,
                              ModelMap model) {
        model.put("designationType", designationType);
        return DESIGNATION_PAGE;
    }
}
