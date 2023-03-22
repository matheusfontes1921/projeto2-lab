package com.app.model.Cliente;
import com.app.model.Pedido.PedidoEntity;
import jakarta.persistence.*;
import java.util.Set;
@Entity
@Table(name="CLIENTE")
public class ClienteEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "cliente")
    private Set<PedidoEntity> pedidos;

}
