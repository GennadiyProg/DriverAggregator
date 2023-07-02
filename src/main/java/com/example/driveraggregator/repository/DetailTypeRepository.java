package com.example.driveraggregator.repository;

import com.example.driveraggregator.model.DetailType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailTypeRepository extends JpaRepository<DetailType, Long> {
    Optional<DetailType> findByName(String name);
}
