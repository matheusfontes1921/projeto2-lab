package com.app.model.Carro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Long> {

    CarroEntity getCarroEntityByMatricula(Long matricula);

}
