package com.trip.customer.service;

import com.trip.customer.mappers.CustomerMapper;
import com.trip.customer.models.requests.CustomerRequest;
import com.trip.customer.models.responses.CustomerResponse;
import com.trip.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;

  public CustomerResponse createCustomer(CustomerRequest request) {
    var customer = repository.save(CustomerMapper.INSTANCE.toCustomer(request));
    return null;
  }
}
