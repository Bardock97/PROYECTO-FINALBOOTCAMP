package com.bootcamp.userService.userService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bootCustomer")
public class BootCustomer {

    @Id
    private String idUser;

    private String dni;
    private String phoneNumber;
    private String emailAddress;

}
