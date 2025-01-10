package org.dit.FrontOfficePortal.service;

import org.dit.FrontOfficePortal.binding.LoginForm;
import org.dit.FrontOfficePortal.binding.SignUp;
import org.dit.FrontOfficePortal.binding.UnlockAccount;
import org.dit.FrontOfficePortal.entity.UserDetails;
import org.dit.FrontOfficePortal.repo.UserDetailsRepo;
import org.dit.FrontOfficePortal.util.EmailUtils;
import org.dit.FrontOfficePortal.util.PwdUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private PwdUtils pwdUtils;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    public String login(LoginForm loginForm) {
        return "";
    }

    @Override
    public boolean signup(SignUp signUp) {

        Optional<UserDetails> user= userDetailsRepo.findByEmail(signUp.getEmail());

        if(user.isPresent()){
            return false;
        }

        UserDetails u=new UserDetails();
        BeanUtils.copyProperties(signUp,u);

        String pwd=pwdUtils.generatePassword();
        u.setPassword(pwd);
        u.setAccountStatus("LOCKED");

        userDetailsRepo.save(u);

        String to=u.getEmail();
        String Subject="Create Your Password";

        StringBuffer body=new StringBuffer("");
        body.append("<h3>Your Account is Created Successfully, Use below link to unlock your account</h3>");
        String temp="Temporary Password : "+pwd+"<br>";
        body.append(temp);
        String link="<a href=\"http://localhost:8080/unlock?email="+ to +"\">Click here to reset password</a>";
        body.append(link);

        emailUtils.sendMail(to,Subject, body.toString());
        return true;
    }

    @Override
    public boolean unlockAccount(UnlockAccount unlockAccount) {

       Optional<UserDetails> user= userDetailsRepo.findByEmail(unlockAccount.getEmail());
       if(user.isPresent()){
           System.out.println(user.get()+user.get().getPassword()+" "+unlockAccount.getTempPwd());
           if(user.get().getPassword().equals(unlockAccount.getTempPwd())){
               System.out.println("same pasword");
               user.get().setPassword(unlockAccount.getCnfPwd());
               user.get().setAccountStatus("UNLOCKED");
               userDetailsRepo.save(user.get());
               return true;
           }else{
               return false;
           }
       }

        return false;
    }

    @Override
    public String forgotPassword(String email) {
        return "";
    }

    @Override
    public boolean validateUser(LoginForm loginForm) {
        Optional<UserDetails> user = userDetailsRepo.findByEmail(loginForm.getEmail());
        return user.map(userDetails -> userDetails.getPassword().equals(loginForm.getPassword())).orElse(false);
    }
}
