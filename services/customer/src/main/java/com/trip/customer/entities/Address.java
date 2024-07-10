package com.trip.customer.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Validated
public class Address {
    private String street;
    private String city;
    private String houseNumber;
    private String zipCode;
}
