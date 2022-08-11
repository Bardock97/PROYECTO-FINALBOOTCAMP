package com.example.customer.customerservice.infrastructure.repository;

import com.example.customer.customerservice.infrastructure.entity.Business;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface IBusinessRepository extends ReactiveCrudRepository<Business, String> {

}
