package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Relationship;
import maks.erp.system.enums.Religion;
import maks.erp.system.model.user.User;
import maks.erp.system.service.DesignationService;
import maks.erp.system.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author duity
 * @since 5/7/24
 */

@Controller
public class RegistrationController {
    private final String REGISTRATION_PAGE = "register";
    @Autowired
    private DesignationService designationService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.put("newUser", new User());

        model.put("genderList", Gender.getGenderList());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());
        model.put("relationshipList", Relationship.getRelationshipList());
        model.put("religionList", Religion.getReligionList());

        return REGISTRATION_PAGE;
    }

    @PostMapping("/register")
    public String addNewUser(@ModelAttribute @Valid User user,
                             @RequestParam("file") MultipartFile file,
                             ModelMap model) throws IOException {
        registrationService.saveNewUser(user, file);
        return "redirect:/" + REGISTRATION_PAGE;
    }
}
