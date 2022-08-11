package com.example.account.accountservice.domain.interfaces;

import com.example.account.accountservice.domain.dto.ProductTypeDto;
import com.example.account.accountservice.infrastructure.entity.ProductType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductTypeService {

    Flux<ProductType> findAll();

    Mono<ProductType> save(ProductTypeDto product_type);

    Mono<ProductType> update(ProductType product_type);

    Mono<ProductType> ShowById(String typeId);

    Mono<Void> delete (String id);

}
