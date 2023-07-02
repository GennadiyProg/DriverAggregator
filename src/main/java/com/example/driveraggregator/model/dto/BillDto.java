package com.example.driveraggregator.model.dto;

import com.example.driveraggregator.model.DollarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {
    private DollarType type;
    private double amount;
}
