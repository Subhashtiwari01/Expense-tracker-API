package com.project.Expense.tracker.API.Service;

import com.project.Expense.tracker.API.Model.AuthenticationToken;
import com.project.Expense.tracker.API.Model.DataObject.SignInInput;
import com.project.Expense.tracker.API.Model.DataObject.SignUpOutput;
import com.project.Expense.tracker.API.Model.User;
import com.project.Expense.tracker.API.Repository.IProductRepo;
import com.project.Expense.tracker.API.Repository.IUserRepo;
import com.project.Expense.tracker.API.Service.Utility.EmailHandler;
import com.project.Expense.tracker.API.Service.Utility.PasswordEncrypted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    IProductRepo productRepo;
    public SignUpOutput addUser(User user) {
        boolean signUpStatus=true;
        String signUpStatusMessage=null;

        User existingUser=userRepo.findFirstByuserEmail(user.getUserEmail());

        if(existingUser!=null){
            signUpStatusMessage="userAlready registered";
            signUpStatus=false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);

        }
        try{
            String encryptedPassword= PasswordEncrypted.encryptionPassword(user.getUserPassword());
            user.setUserPassword(encryptedPassword);
            userRepo.save(user);
            signUpStatusMessage="User registers Successfully";
            signUpStatus=true;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);




        } catch (Exception e) {
            signUpStatusMessage="Internal Error Occurred";
            signUpStatus=false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

    }

    public String userSignIn(SignInInput signInInput) throws NoSuchAlgorithmException {
        String signInStatusMessage=null;

        User existingUser=userRepo.findFirstByuserEmail(signInInput.getEmail());

        if(existingUser==null){
            signInStatusMessage="Email not registered";
            return signInStatusMessage;
        }
        try {
            String encryptedPassword = PasswordEncrypted.encryptionPassword(signInInput.getPassword());
            if (existingUser.getUserPassword().equals(encryptedPassword)) {
                //session
                AuthenticationToken authenticationToken=new AuthenticationToken(existingUser);
                authenticationService.save(authenticationToken);

                String toEmail=existingUser.getUserEmail();
                EmailHandler.sendEmail(toEmail,"testing Email Token Value",authenticationToken.getTokenValue());
                return  "Token sent to your Email";

            }
            else{
                signInStatusMessage="Invalid credential";
                return signInStatusMessage;
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public String getProductByDate(LocalDate date) {
        return productRepo.findByDate(date);
    }
}
