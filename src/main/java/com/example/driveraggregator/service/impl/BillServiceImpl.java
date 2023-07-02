package com.example.driveraggregator.service.impl;

import com.example.driveraggregator.exceptions.ViewMessageException;
import com.example.driveraggregator.model.Bill;
import com.example.driveraggregator.model.DollarType;
import com.example.driveraggregator.repository.BillRepository;
import com.example.driveraggregator.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.driveraggregator.model.DollarType.BLUE;
import static com.example.driveraggregator.model.DollarType.GREEN;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill findByDriver(long driverId) {
        return billRepository.findByDriverId(driverId).orElseThrow(() -> new ViewMessageException(String.format("Driver with id = %d not found", driverId)));
    }


    @Override
    public Bill replenish(long driverId, DollarType type, double money) {
        Bill bill = findByDriver(driverId);
        money = convertMoney(type, money);
        bill.setBalance(bill.getBalance() + money);
        return billRepository.save(bill);
    }

    @Override
    public Bill withdraw(long driverId, DollarType type, double money) {
        Bill bill = findByDriver(driverId);
        money = convertMoney(type, money);
        if (bill.getBalance() >= money) {
            bill.setBalance(bill.getBalance() - money);
        } else {
            throw new ViewMessageException("You don't enough money, balance = " + bill.getBalance());
        }
        return billRepository.save(bill);
    }

    private double convertMoney(DollarType type, double money) {
        return switch (type) {
            case RED -> money;
            case BLUE -> money / BLUE.getConversionValue();
            case GREEN -> money / GREEN.getConversionValue();
        };
    }
}
