package com.example.account.accountservice.infrastructure.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business_account")
@Data
public class BusinessAccount {

  @Id
  private String idBusinessAccount;

  private Business business;
  private BankAccount account;

}
