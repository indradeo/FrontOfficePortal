package org.dit.FrontOfficePortal.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
public class StudentEnquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private Long contact;
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate updationDate;
    @ManyToOne
    private Course course;
    @ManyToOne
    private EnquiryStatus enquiryStatus;
    @ManyToOne
    private UserDetails userId;


}
