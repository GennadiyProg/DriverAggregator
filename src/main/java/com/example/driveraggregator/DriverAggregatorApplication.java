package com.example.driveraggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DriverAggregatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriverAggregatorApplication.class, args);
    }

}
