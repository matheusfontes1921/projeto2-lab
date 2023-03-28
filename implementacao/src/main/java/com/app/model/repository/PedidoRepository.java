package com.app.model.repository;

import com.app.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    LinkedList<Pedido> getPedidoEntitiesByCliente_IdOrderById(Long cliente_id);
    void deleteById(Long id);
}
