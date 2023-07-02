package com.example.driveraggregator.task;

import com.example.driveraggregator.model.Driver;
import com.example.driveraggregator.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class ScheduledTask {
    private final DriverRepository driverRepository;

    @Scheduled(cron = "0 0 1 * * *")
    public void congratulationTask() {
        List<Driver> drivers = driverRepository.findAllByBirthDate(LocalDate.now());
        drivers.forEach(driver -> System.out.println(driver.getFio() + ", happy birthday!"));
    }
}
