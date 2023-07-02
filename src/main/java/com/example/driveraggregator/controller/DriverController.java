package com.example.driveraggregator.controller;

import com.example.driveraggregator.model.Driver;
import com.example.driveraggregator.model.Page;
import com.example.driveraggregator.model.dto.DriverDto;
import com.example.driveraggregator.model.view.DriverVm;
import com.example.driveraggregator.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @PostMapping({"", "/"})
    public DriverVm create(@RequestBody DriverDto driver) {
        return new DriverVm(driverService.save(new Driver(driver)));
    }

    @GetMapping("/{id}")
    public DriverVm findById(@PathVariable long id) {
        return new DriverVm(driverService.findById(id));
    }

    @GetMapping("/page/{pageNumber}/{pageSize}")
    public Page<DriverVm> findAll(@PathVariable int pageNumber, @PathVariable int pageSize) {
        org.springframework.data.domain.Page<Driver> drivers = driverService.findAll(pageNumber, pageSize);
        return new Page<>(drivers.get().map(DriverVm::new).toList(), pageNumber, pageSize, drivers.getTotalElements());
    }

    @PatchMapping("/{driverId}/addcar/{vin}")
    public DriverVm addCar(@PathVariable long driverId, @PathVariable String vin) {
        return new DriverVm(driverService.addCar(driverId, vin));
    }

    @PatchMapping("/{driverId}/removecar/{vin}")
    public DriverVm removeCar(@PathVariable long driverId, @PathVariable String vin) {
        return new DriverVm(driverService.removeCar(driverId, vin));
    }
}
