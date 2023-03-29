package com.app.model.service;

import com.app.model.entity.Cliente;
import com.app.model.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente getClientById(Long id) {
        if(id != null){
            return repository.getClienteById(id);
        }else{
            throw new RuntimeException("Matrícula está nula");
        }
    }

    public boolean clienteExiste(Cliente cliente) {
        return repository.findByCpf(cliente.getCpf()).isPresent();
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente findClienteByEmail(String email) {
        return repository.findClienteByEmail(email);
    }

    public void deleteCliente(Cliente cliente) {
        repository.delete(cliente);
    }

    public List<Cliente> getClientes() {
        return repository.findAll();
    }
}
