package com.example.account.accountservice.infrastructure.repository;

import com.example.account.accountservice.infrastructure.entity.ProductType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends ReactiveCrudRepository<ProductType, String> {


}
