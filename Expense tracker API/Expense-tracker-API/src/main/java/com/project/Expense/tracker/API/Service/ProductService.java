package com.project.Expense.tracker.API.Service;

import com.project.Expense.tracker.API.Model.Product;
import com.project.Expense.tracker.API.Repository.IProductRepo;
import com.project.Expense.tracker.API.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {
    @Autowired
    IProductRepo productRepo;

    public String addProduct(Product product) {
         productRepo.save(product);
        return"Product Saved";
    }
//
//    public String getProduct(Date date) {
//        return productRepo.getReferenceById(date);
//    }
}
