package com.example.account.accountservice.domain.interfaces;

import com.example.account.accountservice.domain.dto.BootCoinADto;
import com.example.account.accountservice.infrastructure.entity.BankAccount;
import com.example.account.accountservice.infrastructure.entity.BootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootCoinAService {

  Flux<BootCoin> findAll();

  Mono<BootCoin> save(BootCoinADto bootCoinADto);

}
