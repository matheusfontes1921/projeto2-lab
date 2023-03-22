package com.app.model.Pedido;

import com.app.model.Cliente.ClienteEntity;
import jakarta.persistence.*;

@Entity
@Table(name="PEDIDO")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private ClienteEntity cliente;

    public PedidoEntity(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public PedidoEntity() {}
}
