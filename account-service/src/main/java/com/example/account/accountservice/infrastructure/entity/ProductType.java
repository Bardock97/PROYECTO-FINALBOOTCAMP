package com.example.account.accountservice.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productType")
@Getter
@Setter
@NoArgsConstructor
public class ProductType {

    @Id
    private String typeId;
    private String description;

}
