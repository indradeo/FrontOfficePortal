package org.dit.FrontOfficePortal.service;

import org.dit.FrontOfficePortal.binding.LoginForm;
import org.dit.FrontOfficePortal.binding.SignUp;
import org.dit.FrontOfficePortal.binding.UnlockAccount;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

   String login(LoginForm loginForm);

   boolean signup(SignUp signUp);

   boolean unlockAccount(UnlockAccount unlockAccount);

   String forgotPassword(String email);

   boolean validateUser(LoginForm loginForm);
}
