package maks.erp.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailsViewController {
    @GetMapping("/viewDetails")
    public String getDetailsView(@RequestParam("selectedUserId") long id) {
        return "";
    }

    @GetMapping("/viewCompanyProfile")
    public String getCompanyProfile(@RequestParam("selectedUserId") long id) {
        return "";
    }
}
