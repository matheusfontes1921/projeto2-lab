package com.app.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Cliente cliente;

    public Pedido(Long id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public Pedido() {}
}
