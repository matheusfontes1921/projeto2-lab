package com.app.controller;

import com.app.model.Carro.CarroEntity;
import com.app.model.Carro.CarroService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {
    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping(value = "/api/getCarroByMatricula/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarroByMatricula(@RequestParam Long matricula){

        CarroEntity carroEntity = carroService.getCarroByMatricula(matricula);

        return ResponseEntity.ok().body(carroEntity);
    }
}