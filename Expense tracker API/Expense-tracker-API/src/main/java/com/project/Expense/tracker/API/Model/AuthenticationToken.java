package com.project.Expense.tracker.API.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationTimeAndDate;

    @OneToOne
    User user;

    public AuthenticationToken(User user){
        this.user=user;
        this.tokenValue= UUID.randomUUID().toString();
        this.tokenCreationTimeAndDate=LocalDateTime.now();
    }
}
