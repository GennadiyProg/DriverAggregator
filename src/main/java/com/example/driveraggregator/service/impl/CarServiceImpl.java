package com.example.driveraggregator.service.impl;

import com.example.driveraggregator.exceptions.ViewMessageException;
import com.example.driveraggregator.model.Car;
import com.example.driveraggregator.model.Detail;
import com.example.driveraggregator.model.dto.CarDto;
import com.example.driveraggregator.repository.CarRepository;
import com.example.driveraggregator.repository.DetailRepository;
import com.example.driveraggregator.service.CarService;
import com.example.driveraggregator.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final DetailRepository detailRepository;
    private final DetailService detailService;

    @Override
    public Car save(CarDto car) {
        Car newCar = new Car(car);
        newCar.setDetails(newCar.getDetails().stream()
                .map(detail -> detailRepository.existsById(detail.getSerialNumber()) ?
                        detailService.findBySerialNumber(detail.getSerialNumber()) :
                        detailService.save(detail))
                .toList());
        return carRepository.save(newCar);
    }

    @Override
    public Car addDetail(String vin, String detailSerialNumber) {
        Car car = carRepository.findById(vin).orElseThrow(() -> new ViewMessageException(String.format("Car with vin = %s not found", vin)));
        Detail detail = detailService.findBySerialNumber(detailSerialNumber);
        if (car.getDetails() == null) car.setDetails(new ArrayList<>());
        car.getDetails().add(detail);
        return carRepository.save(car);
    }

    @Override
    public Car removeDetail(String vin, String detailSerialNumber) {
        Car car = carRepository.findById(vin).orElseThrow(() -> new ViewMessageException(String.format("Car with vin = %s not found", vin)));
        if (car.getDetails() == null || car.getDetails().stream().noneMatch(carDetail -> carDetail.getSerialNumber().equals(detailSerialNumber))) {
            throw new ViewMessageException(String.format("Car with vin = %s not contained detail with serial number = %s", vin, detailSerialNumber));
        }
        car.getDetails().removeIf(carDetail -> carDetail.getSerialNumber().equals(detailSerialNumber));
        return carRepository.save(car);
    }
}
