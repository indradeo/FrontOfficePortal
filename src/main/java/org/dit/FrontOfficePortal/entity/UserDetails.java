package org.dit.FrontOfficePortal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String name;
    private String email;
    private Long contact;
    private String password;
    private String accountStatus;

    @OneToMany(mappedBy = "user")
    private List<StudentEnquiry> enquiries;
    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<StudentEnquiry> getEnquiries() {
        return enquiries;
    }

    public void setEnquiries(List<StudentEnquiry> enquiries) {
        this.enquiries = enquiries;
    }
}
