package com.trip.customer.controller;

import com.trip.customer.models.requests.CustomerRequest;
import com.trip.customer.models.responses.CustomerResponse;
import com.trip.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService service;

  @PostMapping
  public ResponseEntity<CustomerResponse> addCustomer(@RequestBody @Valid CustomerRequest request) {
    return ResponseEntity.ok(service.createCustomer(request));
  }
}
