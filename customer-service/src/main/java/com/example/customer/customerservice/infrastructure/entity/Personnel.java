package com.example.customer.customerservice.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "personnel")
@Getter
@Setter
@NoArgsConstructor
public class Personnel extends Client {

    @Id
    private String idPersonal;

    private String dni;
    private String fullName;



}
