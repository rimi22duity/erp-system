package maks.erp.system.controller;

import maks.erp.system.dto.UserJobDetailsDto;
import maks.erp.system.enums.Currency;
import maks.erp.system.service.DesignationService;
import maks.erp.system.service.userJobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobInformationController {
    private String JOBINFORMATION_PAGE = "jobInformation";

    @Autowired
    private DesignationService designationService;

    @Autowired
    private userJobDetailsService userJobDetailsService;

    @GetMapping("/jobInformation")
    public String getJobInformationForm(ModelMap model) {

        model.put("jobInfoDto", new UserJobDetailsDto());
        model.put("currencyList", Currency.getCurrencySigns());
        model.put("designationList", designationService.getDesignations());

        return "jobInformation";
    }

    @PostMapping("/jobInformation")
    public String saveJobInformations(@ModelAttribute UserJobDetailsDto userJobDetailsDto,
                                      BindingResult result,
                                      ModelMap model) {
        if(result.hasErrors()) {
            model.put("jobInfoDto", userJobDetailsDto);
            return JOBINFORMATION_PAGE;
        }

//        userJobDetailsService.save(userJobDetailsDto);
        return "redirect:/" + JOBINFORMATION_PAGE;
    }
}
