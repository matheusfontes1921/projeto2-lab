package com.app.controller;

import com.app.model.dto.LoginDto;
import com.app.model.service.CarroService;
import com.app.model.entity.Cliente;
import com.app.model.service.ClienteService;
import com.app.model.entity.Pedido;
import com.app.model.service.PedidoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping(value = "api/cliente")
@CrossOrigin
public class ClienteController {
    private final ClienteService clienteService;
    private final PedidoService pedidoService;
    private final CarroService carroService;

    public ClienteController(ClienteService clienteService, PedidoService pedidoService, CarroService carroService) {
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
        this.carroService = carroService;
    }

    @PostMapping("cadastrar")
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        if(clienteService.clienteExiste(cliente))
            return ResponseEntity.badRequest().body("Cliente já cadastrado");

        Cliente clienteCriado = clienteService.cadastrarCliente(cliente);

        return ResponseEntity.ok().body(clienteCriado);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Cliente cliente = clienteService.findClienteByEmail(loginDto.getEmail());
        if(cliente == null)
            return ResponseEntity.badRequest().body("Email ou senha incorretos");
        if(!cliente.getPassword().equals(loginDto.getPassword()))
            return ResponseEntity.badRequest().body("Email ou senha incorretos");

        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Cliente cliente = clienteService.getClientById(id);
        if(cliente == null)
            return ResponseEntity.badRequest().body("Cliente não existe");

        clienteService.deleteCliente(cliente);
        if(clienteService.clienteExiste(cliente))
            return ResponseEntity.badRequest().body("Cliente não deletado");


        return ResponseEntity.ok().body("Cliente deletado");
    }

    @PutMapping ("update")
    public ResponseEntity<?> update(@RequestBody Cliente cliente) {
        Cliente existingClient = clienteService.getClientById(cliente.getId());
        if(existingClient == null)
            return ResponseEntity.badRequest().body("Cliente não existe");

        clienteService.cadastrarCliente(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping(value = "getPedidos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPedidos(@PathVariable Long id) {
        LinkedList<Pedido> pedidos = pedidoService.getPedidoByCLiente(id);

        return ResponseEntity.ok().body(pedidos);
    }

    @PostMapping(value = "createPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> createPedido(@RequestParam Long id, @RequestBody String body) {
        Cliente cliente = clienteService.getClientById(id);
        Pedido pedido = pedidoService.createPedido(cliente);

        return ResponseEntity.ok().body(pedido);
    }
    @PostMapping(value = "deletePedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePedido(@RequestParam Long id) {
        pedidoService.deletePedido(id);

        return ResponseEntity.ok().body("Pedidio deletado");
    }


    @PostMapping(value = "updatePedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> upadatePedido(@RequestParam Long id, @RequestBody String body) {
        return ResponseEntity.ok().body("Não Desenvolvido");
    }
}
