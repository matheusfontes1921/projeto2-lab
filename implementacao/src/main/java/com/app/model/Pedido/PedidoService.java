package com.app.model.Pedido;

import com.app.model.Cliente.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository repository;

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

    public void updatePedido() {

    }

    public PedidoEntity createPedido(ClienteEntity cliente) {
        PedidoEntity p1 = new PedidoEntity(null, cliente);

        repository.save(p1);

        return p1;
    }
}
