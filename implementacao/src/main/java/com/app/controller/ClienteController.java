package com.app.controller;

import com.app.model.Carro.CarroService;
import com.app.model.Cliente.ClienteService;
import com.app.model.Pedido.PedidoEntity;
import com.app.model.Pedido.PedidoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
public class ClienteController {
    private final ClienteService clienteService;
    private final PedidoService pedidoService;
    private final CarroService carroService;

    public ClienteController(ClienteService clienteService, PedidoService pedidoService, CarroService carroService) {
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
        this.carroService = carroService;
    }

    @GetMapping(value = "/api/getPedidos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPedidos(@RequestParam Long id) {
        LinkedList<PedidoEntity> pedidos = pedidoService.getPedidoByCLiente(id);

        return ResponseEntity.ok().body(pedidos);
    }

    @PostMapping(value = "/api/createPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPedido(@RequestParam Long id) {

        return ResponseEntity.ok().body("Não desenvolvido");
    }
    @PostMapping(value = "/api/createPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePedido(@RequestParam Long id) {
        pedidoService.deletePedido(id);

        return ResponseEntity.ok().body("Pedidio deletado");
    }


    @PostMapping(value = "/api/createPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> upadatePedido(@RequestParam Long id) {

        return ResponseEntity.ok().body("Não desenvolvido");
    }
}
