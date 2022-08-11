package com.example.account.accountservice.infrastructure.repository;

import com.example.account.accountservice.infrastructure.entity.BootCoin;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBootCoinARepository extends ReactiveCrudRepository<BootCoin,String> {

}
