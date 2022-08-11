package com.example.account.accountservice.domain.service;

import com.example.account.accountservice.domain.dto.BootCoinADto;
import com.example.account.accountservice.domain.interfaces.IBootCoinAService;
import com.example.account.accountservice.infrastructure.entity.BootCoin;
import com.example.account.accountservice.infrastructure.entity.BootCustomer;
import com.example.account.accountservice.infrastructure.entity.Personnel;
import com.example.account.accountservice.infrastructure.repository.IBootCoinARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinAServicelmpl implements IBootCoinAService {

  @Autowired
  IBootCoinARepository bootCoinARepository;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Override
  public Flux<BootCoin> findAll() {
    return bootCoinARepository.findAll();
  }

  @Override
  public Mono<BootCoin> save(BootCoinADto bootCoinADto) {

    Mono<BootCustomer> personnelMono =
        webClientBuilder.build()
            .get()
            .uri("http://localhost:8080/user/phone/" + bootCoinADto.getPhoneNumber()
            ).retrieve()
            .bodyToMono(BootCustomer.class);

    Mono<BootCoin> bootCoinMono = personnelMono.map(data->{

      BootCoin bootCoin = new BootCoin();

      double bootCoinAmount = bootCoinADto.getBitCoinValue() * 100;

      bootCoin.setBootCoinAmount(bootCoinAmount);
      bootCoin.setCustomer(data);

      return bootCoin;

    });


    return bootCoinMono.flatMap(result -> bootCoinARepository.save(result))
        .defaultIfEmpty(new BootCoin());

  }


}
