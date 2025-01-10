package org.dit.FrontOfficePortal.runners;

import org.dit.FrontOfficePortal.entity.Course;
import org.dit.FrontOfficePortal.entity.EnquiryStatus;
import org.dit.FrontOfficePortal.repo.CourseRepo;
import org.dit.FrontOfficePortal.repo.EnquiryStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private EnquiryStatusRepo statusRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {


        Course course1=new Course();
        course1.setCourseName("AWS");
        Course course2=new Course();
        course2.setCourseName("Java Fullstack");
        Course course3=new Course();
        course3.setCourseName("DevOps");

        EnquiryStatus enq1=new EnquiryStatus();
        enq1.setStatus("New");

        EnquiryStatus enq2=new EnquiryStatus();
        enq2.setStatus("Enrolled");

        EnquiryStatus enq3=new EnquiryStatus();
        enq3.setStatus("Lost");

        //courseRepo.saveAll(Arrays.asList(course1,course2,course3));
        //statusRepo.saveAll(Arrays.asList(enq1,enq2,enq3));
    }
}
