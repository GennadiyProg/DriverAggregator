package com.example.driveraggregator.controller;

import com.example.driveraggregator.model.dto.BillDto;
import com.example.driveraggregator.model.view.BillVm;
import com.example.driveraggregator.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver/{driverId}/bill")
public class BillController {
    private final BillService billService;

    @GetMapping({"", "/"})
    public BillVm findByDriver(@PathVariable long driverId) {
        return new BillVm(billService.findByDriver(driverId));
    }

    @PostMapping("/replenish")
    public BillVm replenish(@PathVariable long driverId, @RequestBody BillDto billDto) {
        return new BillVm(billService.replenish(driverId, billDto.getType(), billDto.getAmount()));
    }

    @PostMapping("/withdraw")
    public BillVm withdraw(@PathVariable long driverId, @RequestBody BillDto billDto) {
        return new BillVm(billService.withdraw(driverId, billDto.getType(), billDto.getAmount()));
    }
}
