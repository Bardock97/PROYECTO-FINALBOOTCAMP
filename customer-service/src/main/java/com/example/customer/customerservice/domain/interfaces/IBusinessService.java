package com.example.customer.customerservice.domain.interfaces;


import com.example.customer.customerservice.domain.dto.BusinessDto;
import com.example.customer.customerservice.infrastructure.entity.Business;
import com.example.customer.customerservice.infrastructure.entity.Personnel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessService {

    Flux<Business> findAll();
    Mono<Business> showById(String id);
    Mono<Business> save(BusinessDto businessDto);
    Mono<Business> update(BusinessDto business);
    Mono<Void> delete(String id);

}