package com.bootcamp.userService.userService.service.impl;

import com.bootcamp.userService.userService.Repository.IBootCustomerRepository;
import com.bootcamp.userService.userService.dto.BootCustomerDto;
import com.bootcamp.userService.userService.entity.BootCustomer;
import com.bootcamp.userService.userService.service.redis.RedisService;
import com.bootcamp.userService.userService.service.interfaces.IBootCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCustomerServiceImpl implements IBootCustomerService {

    @Autowired
    private IBootCustomerRepository userRepository;
    @Autowired
    private RedisService redisService;

    @Override
    public Flux<BootCustomer> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<BootCustomer> save(BootCustomerDto bootCustomerDto) {

        BootCustomer bootCustomer = new BootCustomer();

        bootCustomer.setIdUser(bootCustomerDto.getIdUser());
        bootCustomer.setDni(bootCustomerDto.getDni());
        bootCustomer.setPhoneNumber(bootCustomerDto.getPhoneNumber());
        bootCustomer.setEmailAddress(bootCustomerDto.getEmailAddress());

        return userRepository.save(bootCustomer)
                .flatMap(userObject-> {
                    redisService.saveUser(bootCustomer.getIdUser(), userObject);
                    return Mono.just(userObject);
                });
    }

    @Override
    public Mono<BootCustomer> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

}
