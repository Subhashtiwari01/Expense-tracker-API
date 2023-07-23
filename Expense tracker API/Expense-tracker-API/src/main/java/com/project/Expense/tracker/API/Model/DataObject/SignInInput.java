package com.project.Expense.tracker.API.Model.DataObject;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {
    @Email
    private String email;
    private String password;

}
