package org.dit.FrontOfficePortal.service;

import org.dit.FrontOfficePortal.binding.DashboardResponse;
import org.dit.FrontOfficePortal.binding.EnquirySearchCriteria;
import org.dit.FrontOfficePortal.entity.StudentEnquiry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnquiryService {

    List<String> getCourseNames();
    List<String> getEnquiryStatus();
    DashboardResponse getDashboardData(Integer userId);
    String upsertEnquiry(StudentEnquiry enquiry);
    List<StudentEnquiry> getEnquiries(Integer userId, EnquirySearchCriteria criteria);

    StudentEnquiry getEnquiry(Integer id);

}
