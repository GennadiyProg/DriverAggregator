package com.example.driveraggregator.repository;

import com.example.driveraggregator.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, String> {
}
