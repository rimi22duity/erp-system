package maks.erp.system.controller;


import jakarta.persistence.SequenceGenerator;
import jakarta.validation.Valid;
import maks.erp.system.dto.LeaveInfoDto;
import maks.erp.system.service.LeaveApplicationService;
import maks.erp.system.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LeaveApplicationController {

    private Logger logger = LoggerFactory.getLogger(LeaveApplicationController.class);
    private String LEAVE_APPLICATION_PAGE = "leave_details";

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/createLeave")
    public String leaveApplication( ModelMap model) {
        model.put("leaveInfoDto", new LeaveInfoDto());
        model.put("loggedInUser", securityService.getLoggedInUser());

        return "leave_details";
    }

    @PostMapping("/createLeave")
    public String addLeaveApplication(@ModelAttribute @Valid LeaveInfoDto leaveInfoDto,
                                      BindingResult result,
                                      ModelMap model,
                                      RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            System.out.println("errors");
            model.put("leaveInfoDto", leaveInfoDto);
            model.put("loggedInUser", securityService.getLoggedInUser());

            return LEAVE_APPLICATION_PAGE;
        }

        leaveInfoDto.setUser(securityService.getLoggedInUser().getUser());
        leaveApplicationService.addLeaveApplication(leaveInfoDto);
        redirectAttributes.addFlashAttribute("successMessage",
                "Application saved successfully");

        return "redirect:/createLeave";
    }

    @GetMapping("/leaveApplications")
    public String showListOfApplications(ModelMap model) {
        model.put("leaveApplications", leaveApplicationService.findAll());
        model.put("loggedInUser", securityService.getLoggedInUser());

        return "leave_application_list";
    }
}
