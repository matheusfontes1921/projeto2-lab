package com.app.model.service;

import com.app.model.entity.Automovel;
import com.app.model.repository.CarroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CarroService {
    private CarroRepository repository;

    public Automovel getCarroByMatricula(Long matricula){

        if(matricula != null){
            return repository.getCarroEntityByMatricula(matricula);
        }else{
            throw new RuntimeException("Matrícula está nula");
        }
    }
}
