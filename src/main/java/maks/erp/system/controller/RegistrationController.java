package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Relationship;
import maks.erp.system.enums.Religion;
import maks.erp.system.dto.UserDto;
import maks.erp.system.model.user.User;
import maks.erp.system.service.DesignationService;
import maks.erp.system.service.RegistrationService;
import maks.erp.system.service.UserService;
import maks.erp.system.utils.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

/**
 * @author duity
 * @since 5/7/24
 */

@Controller
public class RegistrationController {

    Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private final String REGISTRATION_PAGE = "register";
    private final String USERS_PAGE = "user_list";
    @Autowired
    private DesignationService designationService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private DateConverter dateConverter;

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String register(ModelMap model) {

        log.info("hello There!");
        model.put("userDto", new UserDto());

        model.put("genderList", Gender.getGenderList());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());
        model.put("relationshipList", Relationship.getRelationshipList());
        model.put("religionList", Religion.getReligionList());

        return REGISTRATION_PAGE;
    }

    @PostMapping("/register")
    public String addNewUser(@Valid @ModelAttribute UserDto userDto,
                             BindingResult result,
                             ModelMap model) throws IOException {
        log.info("hello there from post");
        Optional<User> existingUser = registrationService.getUserByUserName(userDto.getUsername());
        if(existingUser.isPresent()) {
            result.rejectValue(
                    "username",
                    null,
                    "There is already an account registered with the same username");

        }
        if(result.hasErrors()) {

            log.error("error");
            model.put("userDto", userDto);
            return REGISTRATION_PAGE;
        }
        registrationService.saveNewUser(userDto);
        log.info("User: " + userDto.getFirstName());
        model.put("message", "Registration successful!");

        return "redirect:/" + REGISTRATION_PAGE;
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        model.put("users", userService.getUserList());
        model.put("title", "Users");

        return USERS_PAGE;
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("selectedUserId") long id, ModelMap model) {
        UserDto userDto = userService.findUserById(id);

        model.put("title", "Update Information");
        model.put("userDetails", userDto);

        return REGISTRATION_PAGE;
    }
}
