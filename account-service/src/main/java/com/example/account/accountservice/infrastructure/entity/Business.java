package com.example.account.accountservice.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business")
@ToString
@NoArgsConstructor
@Data
public class Business extends Client{
    @Id
    private String businessId;

    private String ruc;
    private String businessName;

    public Business(String businessId)
    {
        this.businessId= businessId;
    }

}

