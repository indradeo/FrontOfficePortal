package org.dit.FrontOfficePortal.controller;

import org.dit.FrontOfficePortal.binding.LoginForm;
import org.dit.FrontOfficePortal.binding.SignUp;
import org.dit.FrontOfficePortal.binding.UnlockAccount;
import org.dit.FrontOfficePortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String SignUpPage(SignUp signUp){

        return "signup";
    }

    @GetMapping("/unlock")
    public String UnlockPage(@RequestParam("email") String email,Model model){
        model.addAttribute("email", email);
        return "unlock";
    }

    @GetMapping("/forgot-password")
    public String forGotPassword(){
        return "forgotPwd";
    }

    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute SignUp signUp, Model model){
        boolean res=userService.signup(signUp);
        if(!res){
            model.addAttribute("failMsg","Enter Unique Email");
            return "signup";
        }
        model.addAttribute("successMsg","User Created");
        return "login";
    }

    @PostMapping("/unlock-account")
    public String unLockAccount(@ModelAttribute UnlockAccount unlockAccount,Model model){

        if(!unlockAccount.getNewPwd().equals(unlockAccount.getCnfPwd())){
            model.addAttribute("email",unlockAccount.getEmail());
            model.addAttribute("msg","Confirmed password should be same as new password");
            return "unlock";
        }
        if(!userService.unlockAccount(unlockAccount)){
            model.addAttribute("email",unlockAccount.getEmail());
            model.addAttribute("msg","Wrong temporary password");
            return "unlock";
        }
        return "login";
    }

    @PostMapping("/validate-user")
    public String validateUser(LoginForm loginForm){

        if(!userService.validateUser(loginForm)){
            return "login";
        }

        return "redirect:/dashboard";
    }
}
