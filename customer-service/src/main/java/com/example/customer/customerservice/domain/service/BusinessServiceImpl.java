package com.example.customer.customerservice.domain.service;

import com.example.customer.customerservice.domain.dto.BusinessDto;
import com.example.customer.customerservice.domain.interfaces.IBusinessService;
import com.example.customer.customerservice.infrastructure.entity.Business;
import com.example.customer.customerservice.infrastructure.repository.IBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private IBusinessRepository businessRepository;

    @Override
    public Flux<Business> findAll() {
        return businessRepository.findAll();
    }

    @Override
    public Mono<Business> showById(String id) {
        return businessRepository.findById(id);
    }

    @Override
    public Mono<Business> save(BusinessDto business) {

        Business businessObject = new Business();

        businessObject.setBusinessId(business.getBusinessId());
        businessObject.setRuc(business.getRuc());
        businessObject.setBusinessName(business.getBusinessName());
        businessObject.setPhoneNumber(business.getPhoneNumber());
        businessObject.setEmailAddress(business.getEmailAddress());

        return businessRepository.save(businessObject);

    }

    @Override
    public Mono<Business> update(BusinessDto business) {

        Mono<Business> monoBusiness = businessRepository.findById(business.getBusinessId());

        monoBusiness=  monoBusiness.map(result->{

            result.setRuc(business.getRuc());
            result.setBusinessName(business.getBusinessName());
            result.setPhoneNumber(business.getPhoneNumber());
            result.setEmailAddress(business.getEmailAddress());
            result.setRuc(business.getRuc());

            return result;

        }).flatMap(result -> businessRepository.save(result));

        return monoBusiness;
    }

    @Override
    public Mono<Void> delete(String id) {
        return  businessRepository.deleteById(id);
    }
}
