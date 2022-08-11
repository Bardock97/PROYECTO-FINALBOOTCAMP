package com.example.customer.customerservice.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "business")
@Getter
@Setter
@NoArgsConstructor
public class Business extends Client{

    @Id
    private String businessId;

    private String ruc;
    private String businessName;

}

