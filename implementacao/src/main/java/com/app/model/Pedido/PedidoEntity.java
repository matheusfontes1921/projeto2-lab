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

    public PedidoEntity(Long id, ClienteEntity cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public PedidoEntity() {}
}
