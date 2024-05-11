package maks.erp.system.controller;

import jakarta.validation.Valid;
import lombok.extern.java.Log;
import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Relationship;
import maks.erp.system.enums.Religion;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.put("newUser", new User());

        model.put("genderList", Gender.getGenderList());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());
        model.put("relationshipList", Relationship.getRelationshipList());
        model.put("religionList", Religion.getReligionList());

        return REGISTRATION_PAGE;
    }

    @PostMapping("/addUser")
    public String addNewUser(@ModelAttribute @Valid User user,
                             @RequestParam("file") MultipartFile file,
                             @RequestParam("birthDate") String birthDate,
                             @RequestParam("joiningDate") String joiningDate,
                             @RequestParam("gender") String genderString,
                             @RequestParam("designationTitle") String designationTitle,
                             @RequestParam("relationshipTitle") String relationshipTitle,
                             @RequestParam("religionTitle") String religionTitle,
                             ModelMap model) throws IOException {

        try{
            System.out.println("Birth date" + birthDate);
            System.out.println("joining date" + joiningDate);
            
            user.setBirthDate(dateConverter.parseDate(birthDate));
            user.setJoiningDate(dateConverter.parseDate(joiningDate));

            Date currentDate = dateConverter.getCurrentDate();
            user.setCreated(currentDate);
            user.setUpdated(currentDate);

            user.setGender(Gender.getGender(genderString));
            user.setReligion(Religion.getReligion(religionTitle));

            EmergencyContactInfo emergencyContactInfo = new EmergencyContactInfo();
            emergencyContactInfo.setRelation(Relationship.getRelationship(relationshipTitle));

            user.setEmergencyContact(emergencyContactInfo);

            user.setGender(Gender.getGender(genderString));
            user.setDesignation(designationService
                    .getDesignationByTitle(designationTitle));

            registrationService.saveNewUser(user, file);
            System.out.println(user);

        } catch(Error e) {
            log.error(e.getLocalizedMessage());
        }

        return "redirect:/" + REGISTRATION_PAGE;
    }
}
