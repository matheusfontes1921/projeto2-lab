package com.app.model.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    LinkedList<PedidoEntity> getPedidoEntitiesByCliente_IdOrderById(Long cliente_id);
    void deleteById(Long id);
    PedidoEntity getPedidoEntityByClienteBeforeCliente_IdAndId(Long cliente_id, Long id);
}
