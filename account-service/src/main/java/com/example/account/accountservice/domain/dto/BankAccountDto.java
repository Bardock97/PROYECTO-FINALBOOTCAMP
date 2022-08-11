package com.example.account.accountservice.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BankAccountDto  {


    private String bankAccountId;
    private String businessId;
    private String personnelId;
    private String productTypeId;
    private String numberAccount;
    private double availableBalance;
    private int commission;
    private int max_number_transactions;


}
