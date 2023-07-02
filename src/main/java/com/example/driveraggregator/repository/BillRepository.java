package com.example.driveraggregator.repository;

import com.example.driveraggregator.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Optional<Bill> findByDriverId(long id);
}
