package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.dto.JobInformationDto;
import maks.erp.system.model.user.User;
import maks.erp.system.service.DesignationService;
import maks.erp.system.service.JobInformationService;
import maks.erp.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobInformationUpdateController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobInformationService jobInformationService;

    @Autowired
    private DesignationService designationService;

    @GetMapping("/editCompanyProfile")
    public String getEditCompanyProfile(@RequestParam("selectedUserId") long id,
                                        ModelMap model) {
        User user = userService.findUserById(id);

        JobInformationDto jobInformationDto = jobInformationService.mapToJobInformationDto(user.getJobInformation());
        jobInformationDto.setUser(user);
        model.put("jobInformationDto", jobInformationDto);
        model.put("designationList", designationService.getDesignations());

        return "edit_Company_profile";
    }

    @PostMapping("/editCompanyProfile")
    public String editCompanyProfile(@Valid @ModelAttribute JobInformationDto jobInformationDto,
                                     BindingResult bindingResult,
                                     ModelMap model) {

        if (bindingResult.hasErrors()) {
            System.out.println("I am at error block");
            System.out.println(jobInformationDto.getJoiningDate());
            model.put("jobInformationDto", jobInformationDto);
            model.put("designationList", designationService.getDesignations());

            return "edit_Company_profile";
        }
        System.out.println("Job information designation Id (from controller): "+ jobInformationDto.getDesignationId());
        jobInformationService.updateCompanyProfile(jobInformationDto);


        return "redirect:/users";

    }
}
