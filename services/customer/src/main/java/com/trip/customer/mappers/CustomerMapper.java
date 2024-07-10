package com.trip.customer.mappers;

import com.trip.customer.entities.Customer;
import com.trip.customer.models.requests.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  Customer toCustomer(CustomerRequest request);
}
