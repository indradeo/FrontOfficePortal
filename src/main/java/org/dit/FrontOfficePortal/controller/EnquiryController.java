package org.dit.FrontOfficePortal.controller;

import org.dit.FrontOfficePortal.binding.LoginForm;
import org.dit.FrontOfficePortal.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @GetMapping("/dashboard")
    public String dashboardPage(@ModelAttribute LoginForm loginForm){

        return "dashboard";
    }

    @GetMapping("/addEnquiry")
    public String addEnquiryPage(){
        return "addEnquiry";
    }

    @GetMapping("/viewEnquiry")
    public String viewEnquiryPage(){
        return "viewEnquiry";
    }
}
