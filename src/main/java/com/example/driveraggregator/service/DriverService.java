package com.example.driveraggregator.service;

import com.example.driveraggregator.model.Driver;
import org.springframework.data.domain.Page;

public interface DriverService {
    Driver save(Driver driver);

    Driver findById(long id);

    Page<Driver> findAll(int pageNumber, int pageSize);

    Driver addCar(long driverId, String carVin);

    Driver removeCar(long driverId, String carVin);
}
