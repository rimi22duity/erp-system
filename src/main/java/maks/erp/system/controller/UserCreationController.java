package maks.erp.system.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Optional;

/**
 * @author duity
 * @since 5/7/24
 */

@Slf4j
@Controller
public class UserCreationController {
    private final String CREATE_USER_PAGE = "create_user";
    private final String USERS_PAGE = "user_list";

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;


    @GetMapping("/createUser")
    public String register(ModelMap model) {
        model.put("userDto", new UserDto());

        return CREATE_USER_PAGE;
    }

    @PostMapping("/createUser")
    public String addNewUser(@Valid @ModelAttribute UserDto userDto,
                             BindingResult result,
                             ModelMap model,
                             RedirectAttributes redirectAttributes) throws IOException {
        Optional<User> existingUser = registrationService.getUserByUserName(userDto.getUsername());

        //log.info("Emergency Contact Relationship: {}", userDto.getEmergencyContact().getRelation());
        if(existingUser.isPresent()) {
            log.error("Username already exist");
            result.rejectValue(
                    "username",
                    null,
                    "There is already an account registered with the same username");
        }

        if(result.hasErrors()) {
            log.error("error occurred ");
            result.getFieldErrors().forEach(fieldError -> System.out.println(fieldError.toString()));
            model.put("userDto", userDto);

            return CREATE_USER_PAGE;
        }

        registrationService.createUser(userDto);
        log.info("In create user post mapping");
        redirectAttributes.addFlashAttribute("successMessage",
                "user saved successfully");
        return "redirect:/createUser";
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        model.put("users", userService.getUserList());
        model.put("title", "Users");

        return USERS_PAGE;
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("selectedUserId") long id,
                           ModelMap model) {
        User user = userService.findUserById(id);
        UserDto userDto = userService.mapToUserDto(user);

        model.put("title", "Update Information");
        model.put("userDto", userDto);

        return CREATE_USER_PAGE;
    }
}
