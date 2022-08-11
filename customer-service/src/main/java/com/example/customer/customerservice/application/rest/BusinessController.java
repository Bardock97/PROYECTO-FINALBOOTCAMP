package com.example.customer.customerservice.application.rest;

import com.example.customer.customerservice.domain.dto.BusinessDto;
import com.example.customer.customerservice.domain.service.BusinessServiceImpl;
import com.example.customer.customerservice.infrastructure.entity.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessServiceImpl businessService;

    @GetMapping
    public Flux<Business> list(){
        return businessService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Business> showById(@PathVariable String id){
        return businessService.showById(id);
    }

    @PostMapping
    public Mono<Business> create(@RequestBody BusinessDto business){
        return  businessService.save(business);
    }

    @PutMapping
    public Mono<Business> update(@RequestBody BusinessDto business){
        return businessService.update(business);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return businessService.delete(id);
    }

}
