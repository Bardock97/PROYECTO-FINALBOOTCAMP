package com.bootcamp.userService.userService.Repository;

import com.bootcamp.userService.userService.entity.BootCustomer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IBootCustomerRepository extends ReactiveCrudRepository <BootCustomer,String> {

  Mono<BootCustomer> findByPhoneNumber(String phoneNumber);

}
