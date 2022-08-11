package com.example.account.accountservice.infrastructure.repository;


import com.example.account.accountservice.infrastructure.entity.BankAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankAccountRepository  extends ReactiveCrudRepository<BankAccount,String> {

}
