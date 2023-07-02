package com.example.driveraggregator.service;

import com.example.driveraggregator.model.Detail;

public interface DetailService {
    Detail save(Detail detail);

    Detail findBySerialNumber(String serialNumber);
}
