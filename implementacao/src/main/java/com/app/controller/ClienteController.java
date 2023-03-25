package com.app.controller;

import com.app.model.Carro.CarroService;
import com.app.model.Cliente.ClienteEntity;
import com.app.model.Cliente.ClienteService;
import com.app.model.Pedido.PedidoEntity;
import com.app.model.Pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private CarroService carroService;


    @GetMapping(value = "/api/getPedidos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPedidos(@RequestParam Long id) {
        LinkedList<PedidoEntity> pedidos = pedidoService.getPedidoByCLiente(id);

        return ResponseEntity.ok().body(pedidos);
    }

    @PostMapping(value = "/api/createPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoEntity> createPedido(@RequestParam Long id, @RequestBody String body) {
        ClienteEntity cliente = clienteService.getClientById(id);
        PedidoEntity pedido = pedidoService.createPedido(cliente);

        return ResponseEntity.ok().body(pedido);
    }
    @PostMapping(value = "/api/createPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePedido(@RequestParam Long id) {
        pedidoService.deletePedido(id);

        return ResponseEntity.ok().body("Pedidio deletado");
    }


    @PostMapping(value = "/api/createPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> upadatePedido(@RequestParam Long id, @RequestBody String body) {
        return ResponseEntity.ok().body("Não Desenvolvido");
    }
}
