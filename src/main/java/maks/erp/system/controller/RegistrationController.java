package maks.erp.system.controller;

import jakarta.validation.Valid;
import lombok.extern.java.Log;
import maks.erp.system.dto.RegistrationDto;
import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Relationship;
import maks.erp.system.enums.Religion;
import maks.erp.system.model.dto.UserDto;
import maks.erp.system.model.user.EmergencyContactInfo;
import maks.erp.system.model.user.User;
import maks.erp.system.service.DesignationService;
import maks.erp.system.service.RegistrationService;
import maks.erp.system.utils.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author duity
 * @since 5/7/24
 */

@Controller
public class RegistrationController {

    Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private final String REGISTRATION_PAGE = "register";
    @Autowired
    private DesignationService designationService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private DateConverter dateConverter;

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.put("userDto", new UserDto());

        model.put("genderList", Gender.getGenderList());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());
        model.put("relationshipList", Relationship.getRelationshipList());
        model.put("religionList", Religion.getReligionList());

        return REGISTRATION_PAGE;
    }

    @PostMapping("/addUser")
    public String addNewUser(@ModelAttribute @Valid UserDto userDto,
                             BindingResult result,
                             ModelMap model) throws IOException {
        registrationService.saveNewUser(userDto);

        return "redirect:/" + REGISTRATION_PAGE;
    }
}
