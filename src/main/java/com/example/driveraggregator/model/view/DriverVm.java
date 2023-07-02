package com.example.driveraggregator.model.view;

import com.example.driveraggregator.model.Car;
import com.example.driveraggregator.model.Driver;
import com.example.driveraggregator.model.DriverLicenseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DriverVm {
    private long id;
    private String fio;
    private String passport;
    private DriverLicenseCategory category;
    private LocalDate birthDate;
    private short experience;
    private List<CarVm> cars;

    public DriverVm(Driver driver) {
        this.id = driver.getId();
        this.fio = driver.getFio();
        this.passport = driver.getPassport();
        this.category = driver.getCategory();
        this.birthDate = driver.getBirthDate();
        this.experience = driver.getExperience();
        if (driver.getCars() != null) {
            this.cars = new ArrayList<>();
            for (Car car : driver.getCars()) {
                cars.add(new CarVm(car));
            }
        }
    }
}
