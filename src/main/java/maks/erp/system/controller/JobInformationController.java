package maks.erp.system.controller;

import maks.erp.system.dto.JobInformationDto;
import maks.erp.system.enums.Currency;
import maks.erp.system.model.user.User;
import maks.erp.system.service.DesignationService;
import maks.erp.system.service.UserService;
import maks.erp.system.service.userJobDetailsService;
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
public class JobInformationController {
    private final String JOBINFORMATION_PAGE = "jobInformation";
    private final String CREATE_COMPANY_PROFILE_PAGE = "create_company_profile";

    @Autowired
    private DesignationService designationService;

    @Autowired
    private UserService userService;

    Logger log = LoggerFactory.getLogger(JobInformationController.class);

    @GetMapping("/jobInformation")
    public String getJobInformationForm(ModelMap model) {

        model.put("jobInfoDto", new JobInformationDto());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());

        return "jobInformation";
    }

    @PostMapping("/jobInformation")
    public String saveJobInformation(@ModelAttribute JobInformationDto jobInformationDto,
                                      BindingResult result,
                                      ModelMap model) {
        if(result.hasErrors()) {
            model.put("jobInfoDto", jobInformationDto);
            return JOBINFORMATION_PAGE;
        }

//        userJobDetailsService.save(userJobDetailsDto);
        return "redirect:/" + JOBINFORMATION_PAGE;
    }

    @GetMapping("/viewCompanyProfile")
    public String viewCompanyProfile(@RequestParam("selectedUserId") long id,
                                     ModelMap model) {
        User user = userService.findUserById(id);
        model.put("jobInfo", user.getJobInformation());

        return "job-info";
    }

    @GetMapping("/createCompanyProfile")
    public String getCreateCompanyProfile(@RequestParam("selectedUserId") long id,
                                     ModelMap model) {
        model.put("jobInfoDto", new JobInformationDto());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());

        model.put("selectedUserId", id);

        return CREATE_COMPANY_PROFILE_PAGE;
    }

    @PostMapping("/createCompanyProfile")
    public String createCompanyProfile(@RequestParam("selectedUserId") long id,
                                       @ModelAttribute JobInformationDto jobInformationDto,
                                       BindingResult result,
                                       RedirectAttributes redirectAttributes,
                                       ModelMap model) {
        if(result.hasErrors()) {
            model.put("jobInfoDto", jobInformationDto);
            log.error("errors in result");

            return CREATE_COMPANY_PROFILE_PAGE;
        }

        userService.saveUserCompanyProfile(jobInformationDto, id);
        redirectAttributes.addFlashAttribute("successMessage",
                "Company Profile Saved Successfully");

        return "redirect:/" + CREATE_COMPANY_PROFILE_PAGE;
    }
}
