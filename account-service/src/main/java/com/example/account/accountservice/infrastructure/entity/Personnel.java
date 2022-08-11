package com.example.account.accountservice.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "personnel")
@ToString
@NoArgsConstructor
@Data
public class Personnel extends Client {

  @Id
  private String idPersonal;

  private String dni;
  private String fullName;

  public Personnel(String idPersonal)
  {
    this.idPersonal= idPersonal;
  }

}
