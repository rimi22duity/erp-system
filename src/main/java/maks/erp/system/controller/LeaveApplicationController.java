package maks.erp.system.controller;


import jakarta.validation.Valid;
import maks.erp.system.dto.LeaveInfoDto;
import maks.erp.system.service.LeaveApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LeaveApplicationController {

    private Logger logger = LoggerFactory.getLogger(LeaveApplicationController.class);
    private String LEAVE_APPLICATION_PAGE = "leave_details";

    @Autowired
    private LeaveApplicationService leaveApplicationService;
    @GetMapping("/add-leave")
    public String leaveApplication( ModelMap model) {
        model.put("leaveInfoDto", new LeaveInfoDto());
        model.put("leaveTypeList", leaveApplicationService.getLeaveTypes());
        System.out.println(leaveApplicationService.getLeaveTypes());

        return LEAVE_APPLICATION_PAGE;
    }

    @PostMapping("/add-leave")
    public String addLeaveApplication(@ModelAttribute @Valid LeaveInfoDto leaveInfoDto,
                                      BindingResult result,
                                      ModelMap model) {
        if(result.hasErrors()) {
            return LEAVE_APPLICATION_PAGE;
        }
        leaveApplicationService.addLeaveApplication(leaveInfoDto);
        model.put("message", "Leave Application Requested Successfully!");
        System.out.println(leaveInfoDto.getLeaveType());
        return "redirect:/" + LEAVE_APPLICATION_PAGE;
    }


}