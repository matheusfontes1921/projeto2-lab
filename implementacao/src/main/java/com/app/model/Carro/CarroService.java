package com.app.model.Carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    @Autowired
    private  CarroRepository repository;

    public CarroEntity getCarroByMatricula(Long matricula){

        if(matricula != null){
            return repository.getCarroEntityByMatricula(matricula);
        }else{
            throw new RuntimeException("Matrícula está nula");
        }
    }
}
