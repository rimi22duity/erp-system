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
 * @author deepty
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
        model.put("birthdate", "");
        model.put("joiningDate", "");

        setupReferenceData(model);

        return DESIGNATION_PAGE;
    }

    @PostMapping("/designation")
    public String designation(@ModelAttribute @Valid Designation designation,
                              BindingResult result,
                              ModelMap model) {

        if (result.hasErrors()) {
            setupReferenceData(model);

            return DESIGNATION_PAGE;
        }

        designationService.save(designation);

        return "redirect:/" + DESIGNATION_PAGE;
    }

    public void setupReferenceData(ModelMap model) {
        model.put("designationList", designationService.getDesignations());
    }
}