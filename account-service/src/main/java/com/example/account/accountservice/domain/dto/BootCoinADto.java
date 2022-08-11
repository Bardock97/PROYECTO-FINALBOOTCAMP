package com.example.account.accountservice.domain.dto;

import com.example.account.accountservice.infrastructure.entity.BootCustomer;
import lombok.Data;

@Data
public class BootCoinADto {

  private String phoneNumber;
  private double bitCoinValue;

}
