package org.dit.FrontOfficePortal.controller;

import jakarta.servlet.http.HttpSession;
import org.dit.FrontOfficePortal.binding.DashboardResponse;
import org.dit.FrontOfficePortal.entity.StudentEnquiry;
import org.dit.FrontOfficePortal.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Model model){
        if(session.isNew()){
            return "redirect:/login";
        }

       Integer userId=(Integer)  session.getAttribute("userId");
       DashboardResponse response= enquiryService.getDashboardData(userId);
        model.addAttribute("username",enquiryService.getUserName(userId));
        model.addAttribute("totalEnq",response.getTotalEnquiries());
        model.addAttribute("enrolledEnq",response.getEnrolledEnquiries());
        model.addAttribute("lostEnq",response.getLostEnquiries());
        return "dashboard";
    }

    @GetMapping("/addEnquiry")
    public String addEnquiryPage(Model model, @RequestParam(value = "id", required = false) Integer id){
        if(session.isNew()){
            return "redirect:/login";
        }
        StudentEnquiry enquiry= new StudentEnquiry();
        if(id!=null){
            enquiry=enquiryService.getEnquiry(id);
        }
        model.addAttribute("courses", enquiryService.getCourseNames());
        model.addAttribute("enqStatus", enquiryService.getEnquiryStatus());
        model.addAttribute("enquiryForm", enquiry);
        return "addEnquiry";
    }

    @PostMapping("/addEnquiry")
    public String addEnq(@ModelAttribute StudentEnquiry enquiry ){

        enquiryService.upsertEnquiry(enquiry , session);

        return "redirect:/dashboard";
    }

    @GetMapping("/viewEnquiry")
    public String viewEnquiryPage(Model model){
        if(session.isNew()){
            return "redirect:/login";
        }
        Integer userId = (Integer)session.getAttribute("userId");
        List<StudentEnquiry>enquiries= enquiryService.getEnquiries(userId);
        model.addAttribute("enquiries", enquiries);
        model.addAttribute("courses", enquiryService.getCourseNames());
        model.addAttribute("enqStatus", enquiryService.getEnquiryStatus());

        return "viewEnquiry";
    }
}
