package com.example.driveraggregator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Page<T> {
    private List<T> content;
    private int page;
    private int elementsOnPage;
    private long totalElements;
}
