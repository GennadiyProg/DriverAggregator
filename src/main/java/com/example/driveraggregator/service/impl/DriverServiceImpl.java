package com.example.driveraggregator.service.impl;

import com.example.driveraggregator.exceptions.ViewMessageException;
import com.example.driveraggregator.model.Bill;
import com.example.driveraggregator.model.Car;
import com.example.driveraggregator.model.Driver;
import com.example.driveraggregator.repository.CarRepository;
import com.example.driveraggregator.repository.DriverRepository;
import com.example.driveraggregator.service.BillService;
import com.example.driveraggregator.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final CarRepository carRepository;
    private final BillService billService;

    @Override
    public Driver save(Driver driver) {
        driverRepository.save(driver);
        billService.save(new Bill(driver, 0));
        return driver;
    }

    @Override
    public Driver findById(long id) {
        return driverRepository.findById(id).orElse(new Driver());
    }

    public Page<Driver> findAll(int pageNumber, int pageSize) {
        return driverRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));
    }

    @Override
    public Driver addCar(long driverId, String carVin) throws ViewMessageException {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new ViewMessageException(String.format("Driver with id = %d not found", driverId)));
        Car car = carRepository.findById(carVin).orElseThrow(() -> new ViewMessageException(String.format("Car with vin = %s not found", carVin)));
        if (driver.getCars().stream().map(Car::getVin).noneMatch(vin -> vin.equals(carVin))) {
            car.setOwner(driver);
            carRepository.save(car);
        }
        return driver;
    }

    @Override
    public Driver removeCar(long driverId, String carVin) throws ViewMessageException {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new ViewMessageException(String.format("Driver with id = %d not found", driverId)));
        if(driver.getCars().stream().map(Car::getVin).noneMatch(vin -> vin.equals(carVin))) {
            throw new ViewMessageException(String.format("Driver with id = %d doesn't have car with vin = %s", driverId, carVin));
        }
        driver.getCars().removeIf(car -> car.getVin().equals(carVin));
        Car car = carRepository.findById(carVin).orElseThrow(() -> new ViewMessageException(String.format("Car with vin = %s not found", carVin)));
        car.setOwner(null);
        carRepository.save(car);
        return driver;
    }


}
