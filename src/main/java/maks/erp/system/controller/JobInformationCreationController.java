package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.dto.JobInformationDto;
import maks.erp.system.model.user.User;
import maks.erp.system.service.DesignationService;
import maks.erp.system.service.JobInformationService;
import maks.erp.system.service.SecurityService;
import maks.erp.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JobInformationCreationController {
    private final String JOBINFORMATION_PAGE = "jobInformation";
    private final String CREATE_COMPANY_PROFILE_PAGE = "create_company_profile";

    @Autowired
    private DesignationService designationService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobInformationService jobInformationService;

    @Autowired
    private SecurityService securityService;

    Logger log = LoggerFactory.getLogger(JobInformationCreationController.class);


    @PostMapping("/companyProfile")
    public String getCreateCompanyProfile(@RequestParam("selectedUserId") long id,
                                     ModelMap model) {
        User user = userService.findUserById(id);
        JobInformationDto jobInformationDto = new JobInformationDto();
        jobInformationDto.setUser(user);

        model.put("jobInformationDto", jobInformationDto);
        model.put("designationList", designationService.getDesignations());

        model.put("selectedUserId", id);
        model.put("loggedInUser", securityService.getLoggedInUser());

        return "create_company_profile";
    }

    @PostMapping("/createCompanyProfile")
    public String createCompanyProfile(@Valid @ModelAttribute JobInformationDto jobInformationDto,
                                       BindingResult result,
                                       RedirectAttributes redirectAttributes,
                                       ModelMap model) {
        if(result.hasErrors()) {
            log.error("errors in result");
            log.info("User ID: {}", jobInformationDto.getUser().getId());

            model.put("jobInformationDto", jobInformationDto);
            model.put("designationList", designationService.getDesignations());
            model.put("loggedInUser", securityService.getLoggedInUser());

            return "create_company_profile";
        }
        log.info("Job info joining date: {}", jobInformationDto.getJoiningDate());
        log.info("Job info currency: {}", jobInformationDto.getCurrency());

        jobInformationService.saveUserCompanyProfile(jobInformationDto);
        redirectAttributes.addFlashAttribute("successMessage",
                "Company Profile Saved Successfully");

        return "redirect:/users";
    }
}
