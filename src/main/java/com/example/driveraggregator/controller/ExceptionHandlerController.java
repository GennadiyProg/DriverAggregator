package com.example.driveraggregator.controller;

import com.example.driveraggregator.exceptions.ViewMessageException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlerController {

    @ExceptionHandler(ViewMessageException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ObjectNode handleViewException(ViewMessageException e) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();
        user.put("message", e.getMessage());
        return user;
    }
}
