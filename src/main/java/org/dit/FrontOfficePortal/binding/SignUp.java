package org.dit.FrontOfficePortal.binding;

import org.springframework.stereotype.Service;

@Service
public class SignUp {
    private String name;
    private String email;
    private Long contact;

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
}
