package com.app.model.Carro;

import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private  CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public CarroEntity getCarroByMatricula(Long matricula){

        if(matricula != null){
            return repository.getCarroEntityByMatricula(matricula);
        }else{
            throw new RuntimeException("Matrícula está nula");
        }
    }
}
