package com.example.driveraggregator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    @Id
    private String serialNumber;
    private String name;
    @ManyToOne
    private DetailType type;
    private int cost;
}
