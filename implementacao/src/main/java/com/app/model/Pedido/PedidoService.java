package com.app.model.Pedido;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class PedidoService {

    PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public LinkedList<PedidoEntity> getPedidoByCLiente(Long cliente_id) {
        if(cliente_id != null) {
            return repository.getPedidoEntitiesByCliente_IdOrderById(cliente_id);
        } else {
            throw new RuntimeException("Cliente é nulo");
        }
    }

    public void deletePedido(Long id) {
        if(id != null) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente é nulo");
        }
    }

    public void updatePedido() {}

    public void createPedido() {}
}