package org.dit.FrontOfficePortal.service;

import jakarta.servlet.http.HttpSession;
import org.dit.FrontOfficePortal.binding.DashboardResponse;
import org.dit.FrontOfficePortal.binding.EnquirySearchCriteria;
import org.dit.FrontOfficePortal.entity.StudentEnquiry;
import org.dit.FrontOfficePortal.entity.UserDetails;
import org.dit.FrontOfficePortal.repo.CourseRepo;
import org.dit.FrontOfficePortal.repo.EnquiryStatusRepo;
import org.dit.FrontOfficePortal.repo.StudentEnquiryRepo;
import org.dit.FrontOfficePortal.repo.UserDetailsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnquiryServiceImpl  implements EnquiryService{

    @Autowired
    private EnquiryStatusRepo enquiryStatusRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private StudentEnquiryRepo enquiryRepo;

    @Override
    public List<String> getCourseNames() {
        return courseRepo.findByCourseName();
    }

    @Override
    public List<String> getEnquiryStatus() {
        return enquiryStatusRepo.findByStatus();
    }

    @Override
    public DashboardResponse getDashboardData(Integer userId) {

        DashboardResponse response= new DashboardResponse();

        Optional<UserDetails> user=userDetailsRepo.findById(userId);
        if(user.isEmpty()){

            return null;
        }
        List<StudentEnquiry> enquiries= user.get().getEnquiries();

        int totalEnq=enquiries.size();
        long enrolledEnq=enquiries.stream().filter(e->e.getEnquiryStatus().equals("Enrolled")).count();
        long lostEnq=enquiries.stream().filter(e->e.getEnquiryStatus().equals("Lost")).count();

        response.setTotalEnquiries(totalEnq);
        response.setEnrolledEnquiries(enrolledEnq);
        response.setLostEnquiries(lostEnq);
        return response;
    }

    @Override
    public List<StudentEnquiry> getEnquiries(Integer userId, EnquirySearchCriteria criteria) {

       List<StudentEnquiry> enquiries= userDetailsRepo.findById(userId).get().getEnquiries();

        System.out.println(enquiries);
        System.out.println("course="+criteria.getCourse());
        System.out.println("Status="+criteria.getEnquiryStatus());

        //filter Logic
        if(null!=criteria.getCourse() && !"-select-".equals(criteria.getCourse())){
            enquiries= enquiries.stream().filter(e->e.getCourse().equals(criteria.getCourse())).collect(Collectors.toList());

        }
        if(null!=criteria.getMode() && !"-select-".equals(criteria.getMode())){
            enquiries= enquiries.stream().filter(e->e.getMode().equals(criteria.getMode())).collect(Collectors.toList());

        }
        if(null!=criteria.getEnquiryStatus() && !"-select-".equals(criteria.getEnquiryStatus())){
            enquiries= enquiries
                    .stream()
                    .filter(e->e.getEnquiryStatus()
                            .equals(criteria.getEnquiryStatus())).collect(Collectors.toList());

        }
        return  enquiries;
    }

    @Override
    public List<StudentEnquiry> getEnquiries(Integer userId) {
        return userDetailsRepo.findById(userId).get().getEnquiries();
    }

    @Override
    public StudentEnquiry getEnquiry(Integer id) {


        return enquiryRepo.findById(id).get();
    }

    @Override
    public String getUserName(Integer userId) {
        return userDetailsRepo.findByName(userId);
    }

    @Override
    public String upsertEnquiry(StudentEnquiry enquiry, HttpSession session) {

        StudentEnquiry enquiry1 = new StudentEnquiry();
        BeanUtils.copyProperties(enquiry,enquiry1);
        Optional<UserDetails> user= userDetailsRepo.findById((Integer)(session.getAttribute("userId")));

        enquiry1.setUserId(user.get());

        enquiryRepo.save(enquiry1);

        return "";
    }
}
