package com.example.account.accountservice.domain.service;

import com.example.account.accountservice.domain.dto.ProductTypeDto;
import com.example.account.accountservice.domain.interfaces.IProductTypeService;
import com.example.account.accountservice.infrastructure.entity.ProductType;
import com.example.account.accountservice.infrastructure.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    private IProductTypeRepository productTypeRepository;


    @Override
    public Flux<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public Mono<ProductType> save(ProductTypeDto product_type) {


        ProductType product_typeObj = new ProductType();

        product_typeObj.setTypeId(product_type.getTypeId());
        product_typeObj.setDescription(product_type.getDescription());

        return productTypeRepository.save(product_typeObj);

    }

    @Override
    public Mono<ProductType> update(ProductType product_type) {

        Mono<ProductType> product_typeMono = productTypeRepository.findById(product_type.getTypeId());

        product_typeMono = product_typeMono.map(result ->{
            result.setDescription(product_type.getDescription());

            return result;
        }).flatMap(result -> productTypeRepository.save(result));


        return product_typeMono;
    }

    @Override
    public Mono<ProductType> ShowById(String typeId) {
        return productTypeRepository.findById(typeId);
    }

    @Override
    public Mono<Void> delete(String id) {
        return productTypeRepository.deleteById(id);
    }

}
