package com.bootcamp.userService.userService.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BootCustomerDto {

    private String idUser;
    private String dni;
    private String phoneNumber;
    private String emailAddress;

}
