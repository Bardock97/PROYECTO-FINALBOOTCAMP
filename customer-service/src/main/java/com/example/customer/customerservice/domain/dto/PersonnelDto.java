package com.example.customer.customerservice.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PersonnelDto{

    private String idPersonal;
    private String dni;
    private String fullName;
    private String phoneNumber;
    private String emailAddress;


}
