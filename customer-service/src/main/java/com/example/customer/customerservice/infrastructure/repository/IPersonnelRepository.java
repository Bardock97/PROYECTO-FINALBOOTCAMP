package com.example.customer.customerservice.infrastructure.repository;

import com.example.customer.customerservice.infrastructure.entity.Personnel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonnelRepository extends ReactiveCrudRepository<Personnel,String> {

}
