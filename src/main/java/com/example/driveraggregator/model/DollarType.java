package com.example.driveraggregator.model;

public enum DollarType {
    RED(1),
    GREEN(2.5),
    BLUE(1.5);
    private final double conversionValue;

    DollarType(double conversionValue) {
        this.conversionValue = conversionValue;
    }

    public double getConversionValue() {
        return conversionValue;
    }
}
