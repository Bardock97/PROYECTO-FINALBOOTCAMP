package com.example.account.accountservice.domain.interfaces;

import com.example.account.accountservice.domain.dto.AccountDto;
import com.example.account.accountservice.domain.dto.BankAccountDto;
import com.example.account.accountservice.infrastructure.entity.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankAccountService {

    Flux<BankAccount> findAll();

    Mono<BankAccount> show(String id);

    Mono<BankAccount> save(BankAccountDto bankAccountDto);

    Mono<BankAccount> update(BankAccountDto bankAccountDto);

    Mono<Void> delete(String id);

    Flux<BankAccount> showBusinessAccounts(String businessId);

}
