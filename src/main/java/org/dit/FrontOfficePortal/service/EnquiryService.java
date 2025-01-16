package org.dit.FrontOfficePortal.service;

import jakarta.servlet.http.HttpSession;
import org.dit.FrontOfficePortal.binding.DashboardResponse;
import org.dit.FrontOfficePortal.binding.EnquirySearchCriteria;
import org.dit.FrontOfficePortal.entity.Course;
import org.dit.FrontOfficePortal.entity.StudentEnquiry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnquiryService {

    List<String> getCourseNames();
    List<String> getEnquiryStatus();
    DashboardResponse getDashboardData(Integer userId);

    List<StudentEnquiry> getEnquiries(Integer userId, EnquirySearchCriteria criteria);
    List<StudentEnquiry> getEnquiries(Integer userId);
    StudentEnquiry getEnquiry(Integer id);

    String getUserName(Integer userId);

    String upsertEnquiry(StudentEnquiry enquiry, HttpSession session);
}
