package com.app.model.Carro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CarroEntity {
    @Id
    @GeneratedValue
    private Long matricula;
    private String ano;
    private String modelo;
    private String placa;
}
