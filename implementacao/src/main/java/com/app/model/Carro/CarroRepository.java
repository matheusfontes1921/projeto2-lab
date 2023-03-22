package com.app.model.Carro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {

    CarroEntity getCarroEntityByMatricula(Long matricula);

}
