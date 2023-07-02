package com.example.driveraggregator.model.view;

import com.example.driveraggregator.model.Bill;
import lombok.Data;

import static com.example.driveraggregator.model.DollarType.BLUE;
import static com.example.driveraggregator.model.DollarType.GREEN;

@Data
public class BillVm {
    private DriverVm driver;
    private double balanceInRedDollars;
    private double balanceInGreenDollars;
    private double balanceInBlueDollars;

    public BillVm(Bill bill) {
        this.driver = new DriverVm(bill.getDriver());
        this.balanceInRedDollars = bill.getBalance();
        this.balanceInGreenDollars = bill.getBalance() * GREEN.getConversionValue();
        this.balanceInBlueDollars = bill.getBalance() * BLUE.getConversionValue();
    }
}
