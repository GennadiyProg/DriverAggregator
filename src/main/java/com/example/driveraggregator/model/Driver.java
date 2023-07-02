package com.example.driveraggregator.model;


import com.example.driveraggregator.model.dto.DriverDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fio;
    private String passport;
    @Enumerated
    private DriverLicenseCategory category;
    private LocalDate birthDate;
    private short experience;
    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    public Driver(long id) {
        this.id = id;
    }

    public Driver(DriverDto driver) {
        this.fio = driver.getFio();
        this.passport = driver.getPassport();
        this.category = driver.getCategory();
        this.birthDate = driver.getBirthDate();
        this.experience = driver.getExperience();
    }
}
