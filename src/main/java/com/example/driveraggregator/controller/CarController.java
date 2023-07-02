package com.example.driveraggregator.controller;

import com.example.driveraggregator.model.dto.CarDto;
import com.example.driveraggregator.model.view.CarVm;
import com.example.driveraggregator.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @PostMapping({"", "/"})
    public CarVm create(@RequestBody CarDto car) {
        return new CarVm(carService.save(car));
    }

    @PostMapping("/{vin}/detail/{detailSerialNumber}/add")
    public CarVm addDetail(@PathVariable String vin, @PathVariable String detailSerialNumber) {
        return new CarVm(carService.addDetail(vin, detailSerialNumber));
    }

    @PostMapping("/{vin}/detail/{detailSerialNumber}/remove")
    public CarVm removeDetail(@PathVariable String vin, @PathVariable String detailSerialNumber) {
        return new CarVm(carService.removeDetail(vin, detailSerialNumber));
    }
}
