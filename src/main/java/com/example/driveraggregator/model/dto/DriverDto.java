package com.example.driveraggregator.model.dto;

import com.example.driveraggregator.model.DriverLicenseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DriverDto {
    private String fio;
    private String passport;
    private DriverLicenseCategory category;
    private LocalDate birthDate;
    private short experience;
}
