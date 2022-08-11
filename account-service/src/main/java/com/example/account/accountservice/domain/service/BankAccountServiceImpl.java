package com.example.account.accountservice.domain.service;

import com.example.account.accountservice.domain.dto.AccountDto;
import com.example.account.accountservice.domain.dto.BankAccountDto;
import com.example.account.accountservice.domain.interfaces.IBankAccountService;
import com.example.account.accountservice.infrastructure.entity.*;
import com.example.account.accountservice.infrastructure.repository.IBankAccountRepository;
import com.example.account.accountservice.infrastructure.repository.IBusinessAccountRepository;
import com.example.account.accountservice.infrastructure.repository.IPersonnelAccountRepository;
import com.example.account.accountservice.infrastructure.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements IBankAccountService {

  @Autowired
  private IBankAccountRepository bankAccountRepository;

  @Autowired
  private IProductTypeRepository productTypeRepository;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Autowired
  private IBusinessAccountRepository businessAccountRepository;

  @Autowired
  private IPersonnelAccountRepository personnelAccountRepository;

  @Override
  public Flux<BankAccount> findAll() {
    return bankAccountRepository.findAll();
  }

  @Override
  public Mono<BankAccount> show(String id) {
    return bankAccountRepository.findById(id);
  }

  @Override
  public Mono<BankAccount> save(BankAccountDto bankAccountDto) {

    Mono<ProductType> productTypeMono = productTypeRepository.findById(bankAccountDto.getProductTypeId());

    Mono<BankAccount> bankAccountMono = productTypeMono.map(productType -> {

      BankAccount bankAccount = new BankAccount();

      bankAccount.setAvailableBalance(bankAccountDto.getAvailableBalance());
      bankAccount.setNumberAccount(bankAccountDto.getNumberAccount());
      bankAccount.setCommission(bankAccountDto.getCommission());
      bankAccount.setProduct_type(productType);
      bankAccount.setMax_number_transactions(bankAccountDto.getMax_number_transactions());

      return bankAccount;

    });

    return bankAccountMono
        .flatMap(bank_account -> saveCustomerAccount(bank_account, bankAccountDto));

  }

  private Mono<BankAccount> saveCustomerAccount(BankAccount bank_account, BankAccountDto bankAccountDto) {

    if (bankAccountDto.getPersonnelId() != null && !bankAccountDto.getPersonnelId().equals("")) {

      Mono<Personnel> personnelMono =
          webClientBuilder.build()
              .get()
              .uri("http://localhost:8080/personnel/" + bankAccountDto.getPersonnelId()
              ).retrieve()
              .bodyToMono(Personnel.class);

      Mono<BankAccount> bankAccountMono = bankAccountRepository.save(bank_account);

      return Mono.zip(bankAccountMono, personnelMono)
          .flatMap(data -> {
            PersonnelAccount personnel_account = new PersonnelAccount();
            personnel_account.setAccount(data.getT1());
            personnel_account.setPersonnel(data.getT2());
            return personnelAccountRepository.save(personnel_account);
          })
          .map(PersonnelAccount::getAccount);

    } else if (bankAccountDto.getBusinessId() != null && !bankAccountDto.getBusinessId().equals("")) {

      Mono<Business> businessMono =
          webClientBuilder.build()
              .get()
              .uri("http://localhost:8080/business/" + bankAccountDto.getBusinessId()
              ).retrieve()
              .bodyToMono(Business.class);

      Mono<BankAccount> bankAccountMono = bankAccountRepository.save(bank_account);

      return Mono.zip(bankAccountMono, businessMono)
          .flatMap(data -> {
            BusinessAccount business_account = new BusinessAccount();
            business_account.setAccount(data.getT1());
            business_account.setBusiness(data.getT2());
            return businessAccountRepository.save(business_account);
          })
          .map(BusinessAccount::getAccount);

    } else {

      return null;

    }

  }

  @Override
  public Mono<BankAccount> update(BankAccountDto bankAccountDto) {
    return null;
  }

  @Override
  public Mono<Void> delete(String id) {
    return bankAccountRepository.deleteById(id);
  }

  @Override
  public Flux<BankAccount> showBusinessAccounts(String businessId) {

    Mono<Business> businessMono =
        webClientBuilder.build()
            .get()
            .uri("http://localhost:8080/business/" + businessId
            ).retrieve()
            .bodyToMono(Business.class);

    Flux<BusinessAccount> businessAccountFlux = businessMono
        .flatMapMany(business -> businessAccountRepository.findAllByBusiness(business));

    Mono<List<BankAccount>> bankAccountsMonoList = businessAccountFlux.collectList()
        .flatMap(this::ListOfBusinessAccounts);

    return bankAccountsMonoList
        .flatMapMany(Flux::fromIterable)
        .log();

  }

  private Mono<List<BankAccount>> ListOfBusinessAccounts(List<BusinessAccount> business_accounts) {

    List<BankAccount> bank_accounts = new ArrayList<>();

    for (BusinessAccount business_account : business_accounts) {
      bank_accounts.add(business_account.getAccount());
    }

    return Mono.just(bank_accounts);
  }

}


