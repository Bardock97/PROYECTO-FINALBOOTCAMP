package com.example.account.accountservice.infrastructure.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personnel_account")
@Data
public class PersonnelAccount {

  @Id
  private String idPersonnelAccount;

  private Personnel personnel;
  private BankAccount account;

}
