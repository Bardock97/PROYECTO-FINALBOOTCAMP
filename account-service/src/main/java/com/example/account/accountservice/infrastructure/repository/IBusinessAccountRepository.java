package com.example.account.accountservice.infrastructure.repository;


import com.example.account.accountservice.infrastructure.entity.Business;
import com.example.account.accountservice.infrastructure.entity.BusinessAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IBusinessAccountRepository extends ReactiveCrudRepository<BusinessAccount,String> {

  Flux<BusinessAccount> findAllByBusiness(Business business);

}
