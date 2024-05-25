package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.dto.DesignationDto;
import maks.erp.system.model.user.Designation;
import maks.erp.system.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/designations")
    public String addDesignations(ModelMap model) {
        model.put("designationDto", new DesignationDto());
        model.put("birthdate", "");
        model.put("joiningDate", "");

        setupReferenceData(model);

        return DESIGNATION_PAGE;
    }

    @GetMapping("/edit")
    public String editDesignation(@RequestParam("selectedDesignationId") long id,
                                  ModelMap model) {
        DesignationDto designationDto = designationService.mapToDesignationDto(
                designationService.getDesignationById(id));

        model.put("title", "Update Designation");
        model.put("designationDto", designationDto);
        model.put("designationId", id);
        setupReferenceData(model);
        return "designation_details";
    }

    @PostMapping("/edit")
    public String editDesignation(@RequestParam("selectedDesignationId") long id,
                                  @ModelAttribute @Valid DesignationDto designationDto,
                                  BindingResult result,
                                  ModelMap model) {
        designationService.editDesignation(id, designationDto);
        return "redirect:/" + DESIGNATION_PAGE;
    }

    @PostMapping("/designation")
    public String designation( @RequestParam("action") String action,
                               @ModelAttribute @Valid DesignationDto designationDto,
                              BindingResult result,
                              ModelMap model) {
        if(!action.equals("close")) {
            System.out.println("Action submit:" + action);
            if (result.hasErrors()) {
                setupReferenceData(model);

                return DESIGNATION_PAGE;
            }

            designationService.save(designationDto);
        } else {
            System.out.println("Action close:" + action);
            model.put("designation", new Designation());
            setupReferenceData(model);
            return DESIGNATION_PAGE;
        }

        return "redirect:/" + DESIGNATION_PAGE;

    }

    public void setupReferenceData(ModelMap model) {
        model.put("designationList", designationService.getDesignations());
    }
}