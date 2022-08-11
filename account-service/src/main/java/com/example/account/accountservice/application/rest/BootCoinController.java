package com.example.account.accountservice.application.rest;

import com.example.account.accountservice.domain.dto.BankAccountDto;
import com.example.account.accountservice.domain.dto.BootCoinADto;
import com.example.account.accountservice.domain.interfaces.IBootCoinAService;
import com.example.account.accountservice.infrastructure.entity.BankAccount;
import com.example.account.accountservice.infrastructure.entity.BootCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bootCoinAccount")
public class BootCoinController {

  @Autowired
  private IBootCoinAService bootCoinAService;

  @GetMapping
  public Flux<BootCoin> list(){
    return bootCoinAService.findAll();
  }

  @PostMapping
  public Mono<BootCoin> create(@RequestBody BootCoinADto bootCoinADto){
    return bootCoinAService.save(bootCoinADto);
  }


}
