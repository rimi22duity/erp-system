package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.model.user.Designation;
import maks.erp.system.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author duity
 * @since 5/4/24
 */

@Controller
public class DesignationController {

    public final String DESIGNATION_PAGE = "designation";

    @Autowired
    private DesignationService designationService;

    @GetMapping("/designation")
    public String addDesignations(ModelMap model) {
        model.put("designation", new Designation());
        return DESIGNATION_PAGE;
    }

    @PostMapping("/designation")
    public String designation(@ModelAttribute @Valid Designation designation,
                              BindingResult result,
                              ModelMap model) {

        if (result.hasErrors()) {

            System.out.println("Has Errors!!");
//            model.put("designation", designation);
            return DESIGNATION_PAGE;
        }
        System.out.println("Title : " + designation.getTitle());
        model.put("designationType", designation);
        designationService.save(designation);

        return DESIGNATION_PAGE;
    }
}
