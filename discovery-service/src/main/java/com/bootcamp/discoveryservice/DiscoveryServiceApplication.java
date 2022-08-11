package com.bootcamp.discoveryservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Starter.
 */

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DiscoveryServiceApplication.class, args);
  }

}
