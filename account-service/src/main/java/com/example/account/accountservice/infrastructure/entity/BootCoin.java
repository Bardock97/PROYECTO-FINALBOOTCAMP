package com.example.account.accountservice.infrastructure.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bootCoinAccount")
@Getter
@Setter
@NoArgsConstructor
public class BootCoin {

  @Id
  private String transactionId;

  private double bootCoinAmount;
  private BootCustomer customer;

}
