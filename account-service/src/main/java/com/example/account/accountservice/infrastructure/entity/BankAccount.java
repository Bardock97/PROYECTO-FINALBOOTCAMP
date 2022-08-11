package com.example.account.accountservice.infrastructure.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankAccount")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {

  @Id
  private String accountId;

  private ProductType product_type;
  private String numberAccount;
  private double availableBalance;
  private int commission;
  private int max_number_transactions;

}
