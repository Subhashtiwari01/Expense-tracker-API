package com.project.Expense.tracker.API.Service;

import com.project.Expense.tracker.API.Model.AuthenticationToken;
import com.project.Expense.tracker.API.Repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authenticationRepo;

    public void save(AuthenticationToken authenticationToken) {
        authenticationRepo.save(authenticationToken);
    }
}
