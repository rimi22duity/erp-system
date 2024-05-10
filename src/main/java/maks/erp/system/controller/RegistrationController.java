package maks.erp.system.controller;

import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Relationship;
import maks.erp.system.enums.Religion;
import maks.erp.system.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author duity
 * @since 5/7/24
 */

@Controller
public class RegistrationController {

    @Autowired
    private DesignationService designationService;

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.put("genderList", Gender.getGenderList());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());
        model.put("relationshipList", Relationship.getRelationshipList());
        model.put("religionList", Religion.getReligionList());

        return "register";
    }
}
