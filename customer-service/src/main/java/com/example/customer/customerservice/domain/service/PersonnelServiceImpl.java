package com.example.customer.customerservice.domain.service;

import com.example.customer.customerservice.domain.dto.PersonnelDto;
import com.example.customer.customerservice.domain.interfaces.IPersonnelService;
import com.example.customer.customerservice.infrastructure.entity.Personnel;
import com.example.customer.customerservice.infrastructure.repository.IPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonnelServiceImpl implements IPersonnelService {

    @Autowired
    private IPersonnelRepository personnelRepository;

    @Override
    public Flux<Personnel> findAll() {
        return personnelRepository.findAll();
    }

    @Override
    public Mono<Personnel> showById(String id) {
        return personnelRepository.findById(id);
    }


    @Override
    public Mono<Personnel> save(PersonnelDto personnelDto) {

        Personnel personnel = new Personnel();
        personnel.setIdPersonal(personnelDto.getIdPersonal());
        personnel.setDni(personnelDto.getDni());
        personnel.setFullName(personnelDto.getFullName());
        personnel.setEmailAddress(personnelDto.getEmailAddress());
        personnel.setPhoneNumber(personnelDto.getPhoneNumber());

        return personnelRepository.save(personnel);

    }

    @Override
    public Mono<Personnel> update(PersonnelDto personnelDto) {

        Mono<Personnel> personnelMono = personnelRepository.findById(personnelDto.getIdPersonal());

        personnelMono = personnelMono.map(client_personnel -> {

            Personnel personnel = client_personnel;

            personnel.setFullName(personnelDto.getFullName());
            personnel.setDni(personnelDto.getDni());
            personnel.setPhoneNumber(personnelDto.getPhoneNumber());
            personnel.setEmailAddress(personnelDto.getEmailAddress());

            return personnel;

        });

        personnelMono = personnelMono.flatMap(result -> {
            return personnelRepository.save(result);
        });

        return personnelMono;
    }

    @Override
    public Mono<Void> delete(String idPersonal) {
        return personnelRepository.deleteById(idPersonal);
    }


}
