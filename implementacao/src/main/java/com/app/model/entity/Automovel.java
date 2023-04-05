package com.app.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "automovel")
public class Automovel {
    @Id
    @GeneratedValue
    private Long matricula;
    private String ano;
    private String marca;
    private String modelo;
    private String placa;
}
