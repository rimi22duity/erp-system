package maks.erp.system.controller;

import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Relationship;
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

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.put("genderList", Gender.getGenderList());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("relationshipList", Relationship.getRelationshipList());

        return "register";
    }
}
