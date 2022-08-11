package com.example.customer.customerservice.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessDto{

    private String businessId;
    private String ruc;
    private String businessName;
    private String phoneNumber;
    private String emailAddress;


}
