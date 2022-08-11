package com.example.account.accountservice.application.rest;


import com.example.account.accountservice.domain.dto.ProductTypeDto;
import com.example.account.accountservice.domain.interfaces.IProductTypeService;
import com.example.account.accountservice.domain.service.ProductTypeServiceImpl;
import com.example.account.accountservice.infrastructure.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @GetMapping
    public Flux<ProductType> list(){
        return productTypeService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ProductType> ShowId(@PathVariable("id") String typeId){
        return productTypeService.ShowById(typeId);
    }

    @PostMapping
    public Mono<ProductType> create (@RequestBody ProductTypeDto product_type){
        return productTypeService.save(product_type);
    }

    @PutMapping
    public Mono<ProductType> update(@RequestBody ProductType product_type){
        return productTypeService.update(product_type);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return productTypeService.delete(id);
    }

}
