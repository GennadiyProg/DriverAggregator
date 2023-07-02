package com.example.driveraggregator.service;

import com.example.driveraggregator.model.Bill;
import com.example.driveraggregator.model.DollarType;

public interface BillService {
    Bill save(Bill bill);

    Bill findByDriver(long driverId);

    Bill replenish(long driverId, DollarType type, double money);

    Bill withdraw(long driverId, DollarType type, double money);

}
