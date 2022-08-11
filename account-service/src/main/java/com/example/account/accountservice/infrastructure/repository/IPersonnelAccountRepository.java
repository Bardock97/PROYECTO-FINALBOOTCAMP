package com.example.account.accountservice.infrastructure.repository;

import com.example.account.accountservice.infrastructure.entity.PersonnelAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonnelAccountRepository extends ReactiveCrudRepository<PersonnelAccount,String> {

}
