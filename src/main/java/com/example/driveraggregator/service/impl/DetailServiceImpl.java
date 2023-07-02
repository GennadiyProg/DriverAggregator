package com.example.driveraggregator.service.impl;

import com.example.driveraggregator.exceptions.ViewMessageException;
import com.example.driveraggregator.model.Detail;
import com.example.driveraggregator.model.DetailType;
import com.example.driveraggregator.repository.DetailRepository;
import com.example.driveraggregator.repository.DetailTypeRepository;
import com.example.driveraggregator.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
    private final DetailRepository detailRepository;
    private final DetailTypeRepository detailTypeRepository;

    @Override
    public Detail save(Detail detail) {
        if (detail.getType() == null) throw new ViewMessageException(String.format("Detail with serial number = %s doesn't contain detail type", detail.getSerialNumber()));
        Optional<DetailType> detailType = detailTypeRepository.findByName(detail.getType().getName());
        if (detailType.isPresent()) {
            detail.setType(detailType.get());
        } else {
            detailTypeRepository.save(detail.getType());
        }
        return detailRepository.save(detail);
    }

    @Override
    public Detail findBySerialNumber(String serialNumber) {
        return detailRepository.findById(serialNumber).orElseThrow(() -> new ViewMessageException(String.format("Detail with serial number = %s not found", serialNumber)));
    }
}
