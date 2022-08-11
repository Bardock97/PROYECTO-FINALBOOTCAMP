package com.example.account.accountservice.application.rest;

import com.example.account.accountservice.domain.dto.BankAccountDto;
import com.example.account.accountservice.domain.interfaces.IBankAccountService;
import com.example.account.accountservice.infrastructure.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

  @Autowired
  private IBankAccountService bankAccountService;

  @GetMapping
  public Flux<BankAccount> list(){
    return bankAccountService.findAll();
  }

  @GetMapping("/business/{id}")
  public Flux<BankAccount> showBusinessAccounts(@PathVariable("id") String businessId){
    return bankAccountService.showBusinessAccounts(businessId);
  }

  @PostMapping
  public Mono<BankAccount> create(@RequestBody BankAccountDto bankAccountDto){
    return  bankAccountService.save(bankAccountDto);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable("id") String id){
    return bankAccountService.delete(id);
  }

}
