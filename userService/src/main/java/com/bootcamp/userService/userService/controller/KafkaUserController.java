package com.bootcamp.userService.userService.controller;

import com.bootcamp.userService.userService.dto.BootCustomerDto;
import com.bootcamp.userService.userService.entity.BootCustomer;
import com.bootcamp.userService.userService.producer.KafkaUserProducer;
import com.bootcamp.userService.userService.service.interfaces.IBootCustomerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user")
public class KafkaUserController {

    private KafkaUserProducer kafkaUserProducer;

    @Autowired
    private IBootCustomerService userService;

    @Autowired
    KafkaUserController(KafkaUserProducer kafkaUserProducer){
        this.kafkaUserProducer= kafkaUserProducer;
    }

    @GetMapping
    public Flux<BootCustomer> list(){
        return userService.findAll();
    }

    @GetMapping("/phone/{phoneNumber}")
    public Mono<BootCustomer> findByPhone(@PathVariable("phoneNumber") String phoneNumber){
        return userService.findByPhoneNumber(phoneNumber);
    }

    @PostMapping
    public Mono<BootCustomer> sendMessageToKafkaTopic (@RequestBody BootCustomerDto bootCustomerDto) {

        String message = new Gson().toJson(bootCustomerDto);

        this.kafkaUserProducer.sendMessage(message);

        return userService.save(bootCustomerDto);
    }

}
