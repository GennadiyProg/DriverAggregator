package com.example.driveraggregator.controller;

import com.example.driveraggregator.model.Detail;
import com.example.driveraggregator.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {
    private final DetailService detailService;

    @PostMapping({"", "/"})
    public Detail create(@RequestBody Detail detail) {
        return detailService.save(detail);
    }
}
