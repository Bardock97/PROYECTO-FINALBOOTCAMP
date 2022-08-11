package com.example.customer.customerservice.application.rest;



import com.example.customer.customerservice.domain.dto.PersonnelDto;
import com.example.customer.customerservice.domain.service.PersonnelServiceImpl;
import com.example.customer.customerservice.infrastructure.entity.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelServiceImpl personnelService;

    @GetMapping
    public Flux<Personnel> list(){
        return personnelService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Personnel> showById(@PathVariable String id){
        return personnelService.showById(id);
    }

    @PostMapping
    public Mono<Personnel> create(@RequestBody PersonnelDto personnel){
        return personnelService.save(personnel);
    }

    @PutMapping
    public Mono<Personnel> update(@RequestBody PersonnelDto personnel){
        return personnelService.update(personnel);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return personnelService.delete(id);
    }


}
