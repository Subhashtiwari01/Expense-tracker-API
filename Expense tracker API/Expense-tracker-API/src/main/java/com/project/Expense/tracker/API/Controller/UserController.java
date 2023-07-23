package com.project.Expense.tracker.API.Controller;

import com.project.Expense.tracker.API.Model.DataObject.SignInInput;
import com.project.Expense.tracker.API.Model.DataObject.SignUpOutput;
import com.project.Expense.tracker.API.Model.Product;
import com.project.Expense.tracker.API.Model.User;
//import com.project.Expense.tracker.API.Service.ProductService;
import com.project.Expense.tracker.API.Service.ProductService;
import com.project.Expense.tracker.API.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @PostMapping("signup")

    public SignUpOutput addUser(@RequestBody User user){
        return userService.addUser(user);

    }
    @PostMapping("userSignIn")

    public String userSignIn(@RequestBody @Valid SignInInput signInInput) throws NoSuchAlgorithmException {
        return userService.userSignIn(signInInput);
    }

    @PostMapping("addproduct")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("getByDate/{date}")
    public String getProductByDate(@PathVariable LocalDate localDate){
        return userService.getProductByDate(localDate);
    }

}
