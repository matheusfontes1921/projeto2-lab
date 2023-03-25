package com.app.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public ClienteEntity getClientById(Long id) {
        if(id != null){
            return repository.getClienteEntityById(id);
        }else{
            throw new RuntimeException("Matrícula está nula");
        }
    }
}
