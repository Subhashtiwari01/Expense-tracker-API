package com.project.Expense.tracker.API.Repository;

import com.project.Expense.tracker.API.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
@Repository
public interface IProductRepo extends JpaRepository<Product,Long> {
    String findByDate(LocalDate date);
}
