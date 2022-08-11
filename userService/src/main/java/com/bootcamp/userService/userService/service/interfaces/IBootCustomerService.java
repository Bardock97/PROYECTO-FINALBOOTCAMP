package com.bootcamp.userService.userService.service.interfaces;

import com.bootcamp.userService.userService.dto.BootCustomerDto;
import com.bootcamp.userService.userService.entity.BootCustomer;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootCustomerService {


    Flux<BootCustomer> findAll();
    Mono<BootCustomer> save(BootCustomerDto bootCustomerDto);
    Mono<BootCustomer> findByPhoneNumber(String phoneNumber);

}
