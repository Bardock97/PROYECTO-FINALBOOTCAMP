package com.example.account.accountservice.infrastructure.entity;

import lombok.Data;



@Data
public class Client {

    private String phoneNumber;
    private String emailAddress;

    public Client(String phoneNumber, String emailAddress) {
        this.phoneNumber=phoneNumber;
        this.emailAddress=emailAddress;
    }

    public Client() {
    }
}
