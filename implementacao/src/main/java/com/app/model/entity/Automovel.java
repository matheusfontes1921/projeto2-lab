package com.app.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovel")
public class Automovel {
    @Id
    @GeneratedValue
    private Long matricula;
    private String ano;
    private String modelo;
    private String placa;
}
