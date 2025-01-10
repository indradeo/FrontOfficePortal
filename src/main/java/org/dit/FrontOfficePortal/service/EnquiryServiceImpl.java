package org.dit.FrontOfficePortal.service;

import org.dit.FrontOfficePortal.binding.DashboardResponse;
import org.dit.FrontOfficePortal.binding.EnquirySearchCriteria;
import org.dit.FrontOfficePortal.entity.StudentEnquiry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryServiceImpl  implements EnquiryService{
    @Override
    public List<String> getCourseNames() {
        return List.of();
    }

    @Override
    public List<String> getEnquiryStatus() {
        return List.of();
    }

    @Override
    public DashboardResponse getDashboardData(Integer userId) {
        return null;
    }

    @Override
    public String upsertEnquiry(StudentEnquiry enquiry) {
        return "";
    }

    @Override
    public List<StudentEnquiry> getEnquiries(Integer userId, EnquirySearchCriteria criteria) {
        return List.of();
    }

    @Override
    public StudentEnquiry getEnquiry(Integer id) {
        return null;
    }
}
