package com.app.model.service;

import com.app.model.entity.Pedido;
import com.app.model.entity.Cliente;
import com.app.model.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PedidoService {
    PedidoRepository repository;

    public LinkedList<Pedido> getPedidoByCLiente(Long cliente_id) {
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

    public Pedido createPedido(Cliente cliente) {
        Pedido p1 = new Pedido(null, cliente);

        repository.save(p1);

        return p1;
    }
}
