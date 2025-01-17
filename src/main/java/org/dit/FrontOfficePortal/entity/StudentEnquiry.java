package org.dit.FrontOfficePortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long contact;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate creationDate;
    @UpdateTimestamp
    @Column(insertable = false, updatable = true)
    private LocalDate updationDate;
    private String course;
    private String mode;
    private String enquiryStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserDetails user;

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getEnquiryStatus() {
        return enquiryStatus;
    }

    public void setEnquiryStatus(String enquiryStatus) {
        this.enquiryStatus = enquiryStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getUpdationDate() {
        return updationDate;
    }

    public void setUpdationDate(LocalDate updationDate) {
        this.updationDate = updationDate;
    }

    public UserDetails getUserId() {
        return user;
    }

    public void setUserId(UserDetails user) {
        this.user = user;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "StudentEnquiry{" +
                "contact=" + contact +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", updationDate=" + updationDate +
                ", course='" + course + '\'' +
                ", enquiryStatus='" + enquiryStatus + '\'' +
                '}';
    }
}
