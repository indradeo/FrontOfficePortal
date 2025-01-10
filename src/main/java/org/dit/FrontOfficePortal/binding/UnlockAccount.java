package org.dit.FrontOfficePortal.binding;

import org.springframework.stereotype.Service;

@Service
public class UnlockAccount {
    private String tempPwd;
    private String newPwd;
    private String cnfPwd;
    private String email;


    public String getCnfPwd() {
        return cnfPwd;
    }

    public void setCnfPwd(String cnfPwd) {
        this.cnfPwd = cnfPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getTempPwd() {
        return tempPwd;
    }

    public void setTempPwd(String tempPwd) {
        this.tempPwd = tempPwd;
    }
}
