package com.example.driveraggregator.model.view;

import com.example.driveraggregator.model.Car;
import com.example.driveraggregator.model.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CarVm {
    private String vin;
    private String number;
    private long owner;
    private List<Detail> details;

    public CarVm(Car car) {
        this.vin = car.getVin();
        this.number = car.getNumber();
        if (car.getOwner() != null) {
            this.owner = car.getOwner().getId();
        }
        this.details = car.getDetails();
    }
}
