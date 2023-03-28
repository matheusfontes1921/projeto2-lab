package com.app.model.repository;

import com.app.model.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Automovel, Long> {

    Automovel getCarroEntityByMatricula(Long matricula);

}
