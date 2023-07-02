package com.example.driveraggregator.model;

import com.example.driveraggregator.model.dto.CarDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private String vin;
    private String number;
    @ManyToMany
    private List<Detail> details;
    @ManyToOne
    private Driver owner;

    public Car(CarDto carDto) {
        this.vin = carDto.getVin();
        this.number = carDto.getNumber();
        this.details = carDto.getDetails();
        if (carDto.getOwner() != 0)
            this.owner = new Driver(carDto.getOwner());
    }
}
