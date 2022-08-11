package com.example.customer.customerservice.domain.interfaces;

import com.example.customer.customerservice.domain.dto.PersonnelDto;
import com.example.customer.customerservice.infrastructure.entity.Personnel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonnelService {

    Flux<Personnel> findAll();
    Mono<Personnel> showById(String id);
    Mono<Personnel> save(PersonnelDto personnel);
    Mono<Personnel> update(PersonnelDto personnel);
    Mono<Void> delete(String idPersonal);

}
