package com.example.account.accountservice.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bootCustomer")
@ToString
@NoArgsConstructor
@Data
public class BootCustomer {

  @Id
  private String idUser;

  private String dni;
  private String phoneNumber;
  private String emailAddress;

}
