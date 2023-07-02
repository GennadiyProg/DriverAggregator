package com.example.driveraggregator.model.dto;

import com.example.driveraggregator.model.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CarDto {
    private String vin;
    private String number;
    private List<Detail> details;
    private long owner;
}
