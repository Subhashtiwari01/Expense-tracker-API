package com.project.Expense.tracker.API.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "product_id")
    private Long productId;

    @JoinColumn(name = "title")
    private String title;
    @JoinColumn(name = "description")
    private String description;
    @JoinColumn(name = "price")
    private Integer price;
    @JoinColumn(name = "date")

    private LocalDateTime date;

    private LocalDateTime time;

    @OneToOne
    @JoinColumn(name = "fk_post_user_id")
    private User user;


}