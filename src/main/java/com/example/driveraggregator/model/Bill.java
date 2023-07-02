package com.example.driveraggregator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Driver driver;
    private double balance;

    public Bill(Driver driver, double balance) {
        this.driver = driver;
        this.balance = balance;
    }
}
