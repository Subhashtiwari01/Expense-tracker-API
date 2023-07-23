package com.project.Expense.tracker.API.Repository;

import com.project.Expense.tracker.API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByuserEmail(String userEmail);

}
