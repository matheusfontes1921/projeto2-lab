package com.app.model.Cliente;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteEntity getClientById(Long id) {
        if(id != null){
            return repository.getClienteEntityById(id);
        }else{
            throw new RuntimeException("Matrícula está nula");
        }
    }
}
