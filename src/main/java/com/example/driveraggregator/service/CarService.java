package com.example.driveraggregator.service;

import com.example.driveraggregator.model.Car;
import com.example.driveraggregator.model.dto.CarDto;

public interface CarService {
    Car save(CarDto car);

    Car addDetail(String vin, String detailSerialNumber);

    Car removeDetail(String vin, String detailSerialNumber);
}
